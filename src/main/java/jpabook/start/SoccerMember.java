package jpabook.start;

import javax.persistence.*;

@Entity
public class SoccerMember {
    @Id
    @Column(name="MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne // Team이라는 테이블과 나는 Many to One 관계이다 (optional이라는 속성이 있는 경우 그 값이 false면 연관된 엔티티가 항상 있어야 한다는 의미 기본값은 true임)
    @JoinColumn(name="TEAM_ID") // 그 테이블이 있을때 조인을 하는 컬럼은 TEAM_ID이다 -> 만약 이걸 생략하면 조인컬럼 기본값은 필드명_참조하는 테이블의 컬럼명이다
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if(this.team!=null){
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }
}
