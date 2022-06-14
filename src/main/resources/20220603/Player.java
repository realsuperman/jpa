package dummy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String userName;

    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT", // Many to Many이므로 조인 테이블이 있어야 한다
    joinColumns = @JoinColumn(name="MEMBER_ID"), // 본인의 조인 컬럼
    inverseJoinColumns = @JoinColumn(name="PRODUCT_ID")) // 상대방의 조인 컬럼
    private List<Product> products = new ArrayList<Product>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
