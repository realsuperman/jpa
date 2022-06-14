package dummy;

import javax.persistence.Entity;

@Entity
//@AttributeOverride(name="id",column=@Column(name="MEMBER_ID")) // 부모에게 상속받은 id 속성의 컬럼명을 MEMBER_ID로 재지정
/*@AttributeOverrides({
        @AttributeOverride(name="id",column=@Column(name="MEMBER_ID")),
        @AttributeOverride(name="name",column=@Column(name="MEMBER_NAME"))
})*/ // 여러개를 사용할거면 복수형인 es를 사용하고 그 안에 단수형들을 넣자
public class ChildEntity1 extends BaseEntity{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


/*
참고로 Entity는 Entity이거나 MappedSuperClass로 지정한 클래스만 상속 받을 수 있다
 */