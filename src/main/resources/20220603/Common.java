package dummy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
public abstract class Common {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

//InheritanceType.SINGLE_TABLE로 지정하면 단일 테이블 전략을 사용한다. 해당 전략은 구분 컬럼(DiscriminatorColumn을 꼭 설정해야 한다 이걸 지정하지 않으면 기본으로 엔티티 이름을 사용한다
//참고로 공통 테이블에 모든 컬럼을 적는 개념이 아니라 공통 테이블은 그대로 두고 JOINED 전략 처럼 엔티티를 상속 받아서 확장시키는 개념이다.