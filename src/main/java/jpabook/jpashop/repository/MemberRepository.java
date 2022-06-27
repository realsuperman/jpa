package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:08
 */
@Repository
public class MemberRepository {

    @PersistenceContext // 스프링에서는 엔티티팩토리에서 생성해서 하는 개념이 아니다 해당 어노테이션을 붙여주면 알아서 엔티티매니져를 설정해준다(엔티티 매니저 주입)
    EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

/* 참고로 엔티티 매니저 팩토리를 주입받으려면 아래와 같이 코드를 작성하면 된다
   @PersistenceUnit
   EntityManagerFactory emf;
 */