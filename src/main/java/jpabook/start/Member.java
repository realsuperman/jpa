package jpabook.start;

import javax.persistence.*;
import java.util.List;

@Entity
/*@NamedQuery( // 정적쿼리 선언
        name="Member.findByUsername",
        query="select m from Member m where m.username=:username"
)*/
/*@NamedQueries({ // 정적쿼리 여러개 선언
        @NamedQuery( // 정적쿼리 선언
                name = "Member.findByUsername",
                query = "select m from Member m where m.username=:username"
        ),
        @NamedQuery( // 정적쿼리 선언
                name = "Member.findByUsername2",
                query = "select m from Member m where m.username=:username"
        )
})*/
/*
@SqlResultSetMapping(name="memberWithOrderCount",
entities = {@EntityResult(entityClass = Member.class)},
columns = {@ColumnResult(name="ORDER_COUNT")})
*/
/*@NamedNativeQuery(
    name = "memberSQL",
    query = "SELECT ID FROM MEMBER WHERE AGE>?"
)*/
/*@SqlResultSetMapping(name="memberWithOrderCount",
entities = {@EntityResult(entityClass = Member.class)},
columns = {@ColumnResult(name="ORDER_COUNT")})
@NamedNativeQuery(name="Member.memberWithOrderCount",
query="SELECT M.ID, AGE, NAME, TEAM_ID, I.ORDER_COUNT \"+\n" +
        "                \"FROM MEMBER M \"+\n" +
        "                \"LEFT JOIN \"+\n" +
        "                \" (SELECT IM.ID, COUNT(*) AS ORDER_COUNT \"+\n" +
        "                \" FROM ORDERS O, MEMBER IM \"+\n" +
        "                \" WHERE O.MEMBER_ID = IM.ID GROUP BY IM.ID) I \"+\n" +
        "                \"ON M.ID=I.ID",
resultSetMapping = "memberWithOrderCount")*/
public class Member {
    @Id @GeneratedValue
    private Long id;
    @Column(name="NAME")
    private String username;
    private int age;
    @OneToMany(mappedBy = "member")
    private List<Order> orders;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
