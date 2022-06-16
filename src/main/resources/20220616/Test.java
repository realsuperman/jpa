package jpabook.start;

import javax.persistence.*;

@Entity
public class Test {
    @Id @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="PROVIDER_NAME")
    PhoneServiceProvider phoneServiceProvider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneServiceProvider getPhoneServiceProvider() {
        return phoneServiceProvider;
    }

    public void setPhoneServiceProvider(PhoneServiceProvider phoneServiceProvider) {
        this.phoneServiceProvider = phoneServiceProvider;
    }
}
