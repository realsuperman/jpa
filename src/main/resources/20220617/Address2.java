package jpabook.start;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address2 {
    private String city;
    private String street;
    private String zipcode;

    public Address2(){}
    public Address2(String city,String street,String zipcode){this.city=city; this.street=street; this.zipcode=zipcode;}

    public String getCity() {
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address2 address2 = (Address2) o;
        return Objects.equals(city, address2.city) &&
                Objects.equals(street, address2.street) &&
                Objects.equals(zipcode, address2.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
