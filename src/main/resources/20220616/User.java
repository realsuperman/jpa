package jpabook.start;

import javax.persistence.*;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
            @AttributeOverride(name = "zipcode.zip", column = @Column(name = "HOME_ZIP")),
            @AttributeOverride(name = "zipcode.plusFour", column = @Column(name = "HOME_PLUS_FOUR")),
    })
    private Address homeAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "state", column = @Column(name = "COMPANY_STATE")),
            @AttributeOverride(name = "zipcode.zip", column = @Column(name = "COMPANY_ZIP")),
            @AttributeOverride(name = "zipcode.plusFour", column = @Column(name = "COMPANY_PLUS_FOUR")),
    })
    private Address companyAddress;
    @Embedded PhoneNumber phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}

/*
    만약 같은 타입으로 하나 더 정의하고 싶은 경우가 있다 예를들어 주소라는 타입으로 선언하되, 한번은 집주소로 한번은 회사주소로 접근 하고 싶을 수 있다
    이럴때는 AttributeOverrides를 써서 해당 Embedded에 있는 컬럼명을 변경해주면 된다. 또한 이건 엔티티에 선언해야지 임베디드 타입에 선언하면 안된다
 */