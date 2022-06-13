package jpabook.start;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Common2 {
    @Id @GeneratedValue
    @Column(name="ITEM_ID")
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

/*해당 전략은 공통 테이블이 존재하고 이걸 상속받는 3개의 클래스가 있다고 가정할 때 자식 클래스들에 부모의 고유값들이 저장되어 있는 형태이다
또한 자식 클래스들은 @DiscriminatorValue를 안쓴다
예를 들자면 부모 클래스가 ID,NAME,AGE이고 자식이 이걸 상속받아 ARTIST라는 컬럼을 추가한다고 했을 때 자식 테이블에 ID NAME AGE ARTIST라는 컬럼이 생기게 된다
JOIN전략에서는 자식에게는 ID ARTIST라는 컬럼만 있고 공통 속성은 부모 테이블에 있다.
SINGLE_TABLE전략에서는 부모 자식의 구분이 없기에 하나의 테이블에 모든 속성이 다 존재한다(이런 경우 A타입의 값을 넣을때는 B타입 C타입 같은 다른 컬럼을 null로 처리해야 하는 단점이 있다)
 */