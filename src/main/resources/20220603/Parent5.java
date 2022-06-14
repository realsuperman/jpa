package dummy;

import javax.persistence.*;

@Entity
public class Parent5 {
    @Id @GeneratedValue
    @Column(name="PARENT_ID")
    private Long id;
    private String name;
    @OneToOne
    @JoinTable(name="PARENT_CHILD",
    joinColumns = @JoinColumn(name="PARENT_ID"),
    inverseJoinColumns = @JoinColumn(name="CHILD_ID"))
    private Child5 child;

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

    public Child5 getChild() {
        return child;
    }

    public void setChild(Child5 child) {
        this.child = child;
    }
}
