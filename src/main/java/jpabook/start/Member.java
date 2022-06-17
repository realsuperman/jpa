package jpabook.start;

import javax.persistence.*;
import java.util.List;

@Entity
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
