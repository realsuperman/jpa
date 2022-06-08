package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook"); // 이 비용은 매우 크므로 딱 한 번만 생성하고 공유해서 사용해야 한다
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            //logic(em);  //비즈니스 로직
            //logic2(em);
            logic3(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");

        //등록
        em.persist(member);

        //수정
        member.setAge(20);

        //한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList(); //JPQL을 실행한 것
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);

    }

    public static void logic2(EntityManager em){
        Board board = new Board();
        em.persist(board);
        System.out.println("board.id= "+board.getId());
    }

    public static void logic3(EntityManager em){
        Board2 board = new Board2();
        em.persist(board);
        System.out.println("board.id= "+board.getId());
    }
}


/*
    참고로 JPQL이 필요한 이유는 JPA에서는 모든 객체들의 정보를 가져올 수 없기 때문임(특정 조건을 만족하는 모든 row를 갖고오는 경우를 생각하면 된다)
    따라서 JPQL이라는 SQL을 추항화한 객체지향 쿼리 언어를 제공한다.
 */

/*
    참고로 여러 DB를 사용할 수 있다. 그런경우 persistence.xml에 persistence-unit를 여러개 만들면 되고 추후에 메인에서 사용시 엔티티팩토리를 2개 만들고 사용하면 된다
 */
/*
    FlushModeType.AUTO는 기본적인 엔티티매니저의 플러쉬 정책이다 해당 정책은 JPQL 실행시(식별자를 기준으로 조회하는 find는 제외) 혹은 커밋을 할 때 Flush를 하라는 의미고
    FlushModeType.COMMIT는 커밋할 때만 플러시 하라는 의미이다
    -> em.setFlushMode(FlushModeType.COMMIT) << 이런식으로 하면 됨
 */