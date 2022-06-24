package jpabook.start;


import javax.persistence.*;

@Entity
/*@SqlResultSetMapping(name="OrderResults",
    entities = {
        @EntityResult(entityClass = Order.class,fields = {
                @FieldResult(name="id",column="order_id"),
                @FieldResult(name="quantity",column = "order_quantity"),
                @FieldResult(name=" ",column="order_item")
        })
    },
    columns = {
        @ColumnResult(name="item_name")
    }
)*/
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private int orderAmount;
    @Embedded
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
