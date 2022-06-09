package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTestMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args){
        Member2 Member2 = createMember2("Member2A","회원2");
        Member2.setUsername("회원명변경");
        mergeMember2(Member2);
    }
    static Member2 createMember2(String id,String userName){
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member2 Member2 = new Member2();
        Member2.setId(id);
        Member2.setUsername(userName);

        em1.persist(Member2);
        tx1.commit();

        em1.close();
        return Member2;
    }
    static void mergeMember2(Member2 Member2){
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member2 mergeMember2 = em2.merge(Member2);
        tx2.commit();

        System.out.println("Member2 = "+Member2.getUsername());
        System.out.println("mergeMember2 = "+mergeMember2.getUsername());
        System.out.println("em2 contains Member2 = "+em2.contains(Member2));
        System.out.println("em2 contains Member2 = "+em2.contains(mergeMember2));
        em2.close();
    }
}
