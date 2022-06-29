package jpabook.jpashop.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.domain.QMember;
import jpabook.jpashop.domain.QOrder;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author holyeye
 */
public class OrderRepositoryImpl extends QueryDslRepositorySupport implements CustomOrderRepository { // 쿼리 DSL을 사용하기 위해 해당 클래스를 상속받았고 메소드를 구현하기 위해 Custom 인터페이스를 구현 하였음

    public OrderRepositoryImpl() {
        super(Order.class);
    } // 생성자에 엔티티 클래스를 넘겨주어야 한다

    @Override
    public List<Order> search(OrderSearch orderSearch) {

        QOrder order = QOrder.order;
        QMember member = QMember.member;
        JPAQueryFactory query = new JPAQueryFactory(getEntityManager());

        /*BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.selectFrom(order)
            query.leftJoin(order.member, member)
                    .where(member.name.contains(orderSearch.getMemberName()));

        }

        if (orderSearch.getOrderStatus() != null) {
            query.where(order.status.eq(orderSearch.getOrderStatus()));
        }

        return query.fetch();*/
        return null;
    }
}

/*
    복잡한 쿼리(명세)같은걸 JPA가 제공하는 명세를 이용해서 코딩할 수 있지만 querydsl의 모든 기능을 사용해서 하는게 더 편할 수 있다
 */