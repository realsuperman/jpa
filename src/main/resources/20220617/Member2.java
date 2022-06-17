package jpabook.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member2 {
    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Address2 homeAddress;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOODS", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME") // 사용하는 컬럼이 하나면 @Column을 사용해서 컬럼명을 지정할 수 있다
    private Set<String> favoriteFodds = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
/*    @ElementCollection
    @CollectionTable(name="ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
    private List<Address2> addressHistory = new ArrayList<>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address2 getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address2 homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFodds() {
        return favoriteFodds;
    }

    public void setFavoriteFodds(Set<String> favoriteFodds) {
        this.favoriteFodds = favoriteFodds;
    }

/*    public List<Address2> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address2> addressHistory) {
        this.addressHistory = addressHistory;
    }*/
}
