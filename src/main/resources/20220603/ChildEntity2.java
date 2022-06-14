package dummy;

import javax.persistence.Entity;

@Entity
public class ChildEntity2 extends BaseEntity {
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
