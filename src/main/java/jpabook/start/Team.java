package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team") // 양방향 매핑인 경우 mappedBy라는 속성을 줘야하고 이 값은 반대쪽 매핑의 필드 이름을 주면 된다
    private List<Member> members = new ArrayList<Member>();

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    양방향일때 mappedBy가 필요한 이유는 객체에는 양방향 연관관계가 없기 때문이다 한마디로 단방향 연결관계를 2개 생성한 것과 같다
 */