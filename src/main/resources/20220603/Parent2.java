package dummy;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent2 {
    @EmbeddedId
    private ParentId2 id;

    private String name;

    public ParentId2 getId() {
        return id;
    }

    public void setId(ParentId2 id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
    IdClass가 아닌 EmbeddedId의 경우 키 테이블을 레퍼런스 변수로 선언 한다(IdClass는 각각 속성명을 적고 @Id로 매핑하는 형식 이였음)
    또한 해당 EmbeddedId의 대상 클래스에는 Embeddable이라는 어노테이션을 붙여야 한다 @IdClass의 경우는 키테이블에 어노테이션 설정해야 하는 건 없음
 */