package jpabook.start;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoubleTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args){
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();
        Member member = new Member();
        member.setName("최성훈");
        em1.persist(member);

        Item item = new Item();
        item.setName("치즈");
        item.setPrice(1000);
        em1.persist(item);

        Order order = new Order();
        order.setMember(member);
        em1.persist(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setItem(item);
        em1.persist(orderItem);


        tx1.commit();
        em1.close();
/*        tx1.begin();
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        em1.persist(team1);

        SoccerMember member = new SoccerMember();
        member.setId("member1");
        member.setUsername("회원1");
        member.setTeam(team1);
        em1.persist(member);
        Team test = em1.find(Team.class,"team1");
        System.out.println(test.getMembers().size());
        tx1.commit();
        em1.clear();
        Team test2 = em1.find(Team.class,"team1");
        System.out.println(test2.getMembers().size());*/
        /*Team teamA = new Team();
        teamA.setId("test");
        teamA.setName("ㅇㅇ");
        em1.persist(teamA);

        Team teamB = new Team();
        teamB.setId("test2");
        teamB.setName("ㅇㅇ2");
        em1.persist(teamB);

        SoccerMember member1 = new SoccerMember();
        member1.setId("csh");
        member1.setUsername("테스트");
        member1.setTeam(teamA);
        em1.persist(member1);

        member1.setTeam(teamB);
        em1.close();*/
    }
}
