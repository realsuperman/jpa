package jpabook.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.PERSIST)
    private List<Child> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

/*
    이 개체가 persist되는 시점에 casecade로 지정된 녀석도 함께 persist된다 이건 매핑이런거랑 관련이 1도 없다 그냥 편의성이다
    참고로 CascadeType.REMOVE도 있다 이건 부모 엔티티 삭제시 컬렉션 안에 있는 자식 엔티티도 삭제한다
    또한 여러 CascadeType을 지정할 수 있다 그리고 해당 속성들은 플러시를 호출할 때 발생한다.
    orphanRemoval이라는 속성을 줄 수 있다 해당 속성은 엔티티의 컬렉션에서 자식 엔티티의 참조 제거시 자식 엔티티가 자동으로 삭제되는 기능이다
    한마디로 컬렉션에서 빼면 빼진 엔티티가 삭제된다(물론 플래시가 발생하는 시점) 이 속성은 OneToOne이나 OneToMany에만 사용 가능
 */