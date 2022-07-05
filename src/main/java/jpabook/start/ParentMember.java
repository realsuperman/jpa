package jpabook.start;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Cacheable//(엔티티를 캐시하는 방법)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) //(하이버네이트 전용으로 캐시와 관련된 더 세밀한 설정을 할 때 사용한다)
@Entity
public class ParentMember {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "parentMember",cascade = CascadeType.ALL)
    private List<ChildMember> childMembers = new ArrayList<>();

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

    public List<ChildMember> getChildMembers() {
        return childMembers;
    }

    public void setChildMembers(List<ChildMember> childMembers) {
        this.childMembers = childMembers;
    }
}
