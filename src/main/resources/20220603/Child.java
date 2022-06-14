package dummy;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    private String id;
    private String Name;
    @ManyToOne
    @JoinColumns({ // 상대가 복합키이기 때문에 JoinColumns를 쓰는 것임(비식별 관계임)
        @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"), // JoinColumn의 name 속성과 referencedColumnName 속성의 값이 같으면 referencedColumnName 생략 가능
        @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2") // 참고로 referencedColumnName은 기본키외에 값을 FK로 설정할 때 사용하는 값이다 생략하면 그 테이블의 PK로 지정됨
    })
    private Parent parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
