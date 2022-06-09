package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class SoccerTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        queryLoginJoin(em);
        /*try {
            tx.begin();
            Team team1 = new Team();
            team1.setId("tesm1");
            team1.setName("팀1");
            em.persist(team1);

            SoccerMember member1 = new SoccerMember();
            member1.setId("member1");
            member1.setUsername("회원1");
            member1.setTeam(team1);
            em.persist(member1);

            SoccerMember member2 = new SoccerMember();
            member2.setId("member2");
            member2.setUsername("회원2");
            member2.setTeam(team1);
            em.persist(member2);
            //queryLoginJoin(em);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }*/

    }
    public static void queryLoginJoin(EntityManager em){
        String jpql = "select m from SoccerMember m join m.team t where "+"t.name=:teamName";
        List<SoccerMember> resultList = em.createQuery(jpql,SoccerMember.class) // jpql이다
            .setParameter("teamName","팀1")
            .getResultList();
        for(SoccerMember member : resultList){
            System.out.println("[query] member.username= "+member.getUsername());
        }
    }
}
