package jpabook.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChildMember {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ParentMember parentMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParentMember getParentMember() {
        return parentMember;
    }

    public void setParentMember(ParentMember parentMember) {
        this.parentMember = parentMember;
    }
}
