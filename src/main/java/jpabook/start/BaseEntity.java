package jpabook.start;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // 이 어노테이션은 부모테이블은 논리상으로 존재하게 한다 즉, 실제 테이블과 매핑은 안시킨다(어지간하면 추상 클래스로 만들자)
public abstract class BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
