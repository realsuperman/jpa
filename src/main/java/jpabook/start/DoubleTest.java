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

/*        Book book = new Book();
        book.setAuthor("최성훈");
        book.setIsbn("12345");
        em1.persist(book);

        Album album = new Album();
        album.setArtist("최성훈");
        em1.persist(album);

        Movie movie = new Movie();
        movie.setDirector("최성훈");
        movie.setActor("최성훈");
        em1.persist(movie);*/
        tx1.commit();
        em1.close();
/*        Member member = new Member();
        member.setName("최성훈");
        em1.persist(member);

        Item item = new Item();
        item.setName("치즈");
        item.setPrice(1000);
        em1.persist(item);
        Item item2 = new Item();
        item2.setName("피자");
        item2.setPrice(10000);
        em1.persist(item2);

        Order order = new Order();
        order.setMember(member);
        em1.persist(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setCount(1);
        orderItem.setOrderPrice(item.getPrice());
        em1.persist(orderItem);
        order.addOrderItem(orderItem);

        Delivery delivery = new Delivery();
        em1.persist(delivery);
        delivery.setOrder(order);
        order.setDelivery(delivery);

        Category category = new Category();
        category.setName("육류");
        category.getItems().add(item);
        category.getItems().add(item2);
        em1.persist(category);
        item.getCategories().add(category);*/

        /*Member member = new Member();
        member.setName("최성훈");
        em1.persist(member);

        Item item = new Item();
        item.setName("치즈");
        item.setPrice(1000);
        em1.persist(item);
        Item item2 = new Item();
        item2.setName("피자");
        item2.setPrice(10000);
        em1.persist(item2);

        Order order = new Order();
        order.setMember(member);
        em1.persist(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setCount(1);
        orderItem.setOrderPrice(item.getPrice());
        em1.persist(orderItem);
        order.addOrderItem(orderItem);*/
/*        Player player1 = new Player();
        player1.setUserName("member1");
        Player player2 = new Player();
        player2.setUserName("member2");

        Team team = new Team();
        team.setName("최성훈팀");
        team.getMembers().add(player1);
        team.getMembers().add(player2);
        em1.persist(player1);
        em1.persist(player2);
        em1.persist(team);*/
/*        Product product = new Product();
        product.setId("productA");
        product.setName("상품A");
        em1.persist(product);

        Player player = new Player();
        player.setId("member1");
        player.setUserName("회원1");
        player.getProducts().add(product);
        em1.persist(player);

        tx1.commit();
        em1.close();*/
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
