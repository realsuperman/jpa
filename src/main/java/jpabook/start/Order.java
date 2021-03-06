package jpabook.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@NamedEntityGraph(name = "Order.withMember",attributeNodes = {@NamedAttributeNode("member")})
@NamedEntityGraph(name="Order.withAll",attributeNodes = {
        @NamedAttributeNode("member"),
        @NamedAttributeNode(value="orderItems",subgraph = "orderItems")
    },
    subgraphs = @NamedSubgraph(name="orderItems",attributeNodes = {
        @NamedAttributeNode("item")
    })
)
@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity{
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @Temporal(TemporalType.TIMESTAMP) // 참고로 기본값이 TIMESTAMP이므로 생략해도 된다
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if(this.member!=null){
            this.member.getOrders().remove(this);
        }
        this.member=member;
        member.getOrders().add(this);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
