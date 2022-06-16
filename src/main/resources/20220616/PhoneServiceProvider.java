package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneServiceProvider {
    @Id
    @Column(name="PROVIDER_NAME")
    private String name;

    public PhoneServiceProvider(){}
    public PhoneServiceProvider(String name){this.name=name;}

    public String getName() {
        return name;
    }

}
