package jpabook.start;

import javax.persistence.*;

@Entity
public class Child4 {
    @EmbeddedId
    private ChildId2 id;

    @MapsId("parentId") // ChildId.parentId 매핑 (위에서 EmdeddedId로 퉁쳤기에 이것도 키라는 의미에서 MapsID를 붙이는 것)
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    public Parent parent;
    private String name;

    public ChildId2 getId() {
        return id;
    }

    public void setId(ChildId2 id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
    EmbeddedId로 식별관계 정의시 외래키 부분에 MapsId라는 속성을 집어넣어야 한다
 */