package jpabook.start;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;
/*    private String city;
    private String street;
    private String zipCode;*/
    @Embedded
    private Address address;

    //@BatchSize(size=5) // 이거를 설정하면 개체를 가지고오는 시점에 size개수 만큼을 미리 메모리에 가져다 둔다
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "member")
    //@OrderBy("id desc,orderDate asc") // 이런식으로 orderby절을 이용하여 순서를 관리할 수 있다
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

/*    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }*/
}
