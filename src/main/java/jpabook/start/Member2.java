package jpabook.start;

import javax.persistence.*;  //**
import java.util.Date;

/**
 * User: HolyEyE
 * Date: 13. 5. 24. Time: 오후 7:43
 */
//@org.hibernate.annotations.DynamicUpdate
    /*
        위의 주석 처리한 태그는 update시 변경된 컬럼만 변경하라는 의미이다. 원래는 개체의 모든 필드를 다 수정하는 전략이지만(기본전략)
        필드가 많은 경우 시간이 오래 걸릴 수 있다. 그랬을 땐 위 처럼 전략을 바꾸는 것도 좋다
     */
@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(
        name="NAME_AGE_UNIQUE",
        columnNames = {"NAME","AGE"}
)})
public class Member2 {

    @Id
    private String id;

    @Column(name = "NAME", nullable = false, length = 10) // 이 처럼 Column에 상세 정보를 넣을 수 있다
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // 자바의 enum을 사용하려면 해당 어노테이션으로 매핑해야 한다
    private RoleType roleType;

    @Temporal(TemporalType.TIME) // 날짜 타입은 Temporal을 통해 매핑한다
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입은 Temporal을 통해 매핑한다
    private Date lastModifiedDate;

    @Lob // 데이터베이스의 CLOB,BLOB 타입으로 저장한다는 의미
    private String description;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
