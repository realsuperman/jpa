package jpabook.start;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class DoubleTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args) throws Exception {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();

        tx1.begin();
        CriteriaBuilder cb = em1.getCriteriaBuilder();

        CriteriaQuery<Member> m = cb.createQuery(Member.class);
        Root<Member> root = m.from(Member.class);
        m.select(root);
        m.where(cb.greaterThan(root.get("age"),10));
        m.orderBy(cb.desc(root.get("age")));
        List<Member> list = em1.createQuery(m).getResultList();
        for(Member member: list) System.out.println(member.getUsername());
/*        CriteriaBuilder cb = em1.getCriteriaBuilder(); // Criteria를 사용하려면 빌더를 항상 선언해야 한다.
        CriteriaQuery<Member> cq = cb.createQuery(Member.class); // Criteria 생성 및 반환 타입 지정
        Root<Member> m = cq.from(Member.class); // FROM 절
        cq.select(m);
        Predicate usernameEqual = cb.equal(m.get("username"),"회원1");
        javax.persistence.criteria.Order ageFesc = cb.desc(m.get("age"));
        cq.select(m).where(usernameEqual).orderBy(ageFesc);
        List<Member> list = em1.createQuery(cq).getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
/*        Member member = em1.createNamedQuery("Member.findByUsername",Member.class).setParameter("username","최성훈").getSingleResult(); // 정적쿼리 실행한 것 createNamedQuery라고 적어야 함 주의필요
        System.out.println(member.getUsername());*/
/*        List<Object[]> list = em1.createQuery("SELECT case when m.age<=10 then '학생' WHEN m.age<=30 THEN '성인' ELSE '일반' END ,m.username FROM Member m").getResultList();
        for(Object[] o : list) System.out.println( (String)o[0] + " "+(String)o[1]);*/
/*        List<Member> list = em1.createQuery("select m from Member m where m.orders is empty ").getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
        /*List<Member> list = em1.createQuery("SELECT m FROM Member m where m.id IN (select o.member.id from Order o )").getResultList();
        for(Member member : list){
            System.out.println(member.getUsername());
        }*/
        /*List<Member> list = em1.createQuery("select m from Member m where (select count(o) from Order o where m=o.member)>0").getResultList();
        for(Member m : list){
            System.out.println(m.getUsername());
        }*/
/*        List<Team> list = em1.createQuery("SELECT t FROM Team t LEFT JOIN t.member m WHERE t.id=1").getResultList();
        System.out.println(list.size());*/
/*        String jpql = "select t from Team t join t.member where t.name='LG'";
        List<Team> teams = em1.createQuery(jpql,Team.class).getResultList();
        System.out.println(teams.size());
        for(Team team : teams){
            System.out.println(team.getName());
            for(Member member : team.getMember()){
                System.out.println(member.getUsername());
            }
        }*/
        //for(Object[] obj: list){
            //System.out.println("test");
            //Team team = (Team)obj[0];
            //Member member = (Member) obj[1];
            //System.out.println(member.getUsername());
        //}
/*        List<Member> list = em1.createQuery("SELECT m FROM Member m join fetch m.team").getResultList();
        for(Member member : list){
            System.out.println(member.getUsername+());
        }*/
/*        List<Member> list = em1.createQuery("SELECT m FROM Member m join fetch m.team").getResultList();
        Team team = list.get(0).getTeam();
        boolean isLoad = emf.getPersistenceUnitUtil().isLoaded(team);
        System.out.println(isLoad);*/
        //List<Object[]> result = em1.createQuery("SELECT t,m FROM Team t LEFT JOIN t.member m ON t.id=1L").getResultList();
/*        List<Object[]> result = em1.createQuery("SELECT m,t from Member m left join m.team t on t.name='SSG'").getResultList();
        System.out.println(result.size());
        for(Object[] obj : result){
            Team team = (Team) obj[0];
            Member member = (Member) obj[1];
            System.out.println(member.getUsername());
        }*/
/*        List<Object[]> result = em1.createQuery("SELECT m,t FROM Member m JOIN m.team t").getResultList();
        for(Object[] o : result){
            Member member = (Member)o[0];
            Team team = (Team)o[1];

        }*/
/*        String teamName = "팀A";
        String query = "SELECT m FROM Member m JOIN m.team t WHERE t.name=?1";
        List<Member> list = em1.createQuery(query,Member.class).setParameter(1,"SSG").getResultList();
        System.out.println(list.get(0).getUsername());*/
/*        List<Object[]> list = em1.createQuery("SELECT t.name, COUNT(m.age), SUM(m.age), AVG(m.age), MAX(m.age),MIN(m.age) FROM Member m LEFT JOIN m.team t GROUP BY t.name").getResultList();
        for(Object[] o : list){
           System.out.println((String)o[0]+" "+(double)o[3]);
        }*/
/*        TypedQuery<Member> query = em1.createQuery("SELECT m FROM Member m ORDER BY m.username DESC",Member.class);
        query.setFirstResult(0);
        query.setMaxResults(20);
        List<Member> list = query.getResultList();
        for(Member m : list) System.out.println(m.getUsername());*/
/*        List<UserDto> list = em1.createQuery("SELECT new jpabook.start.UserDto(m.username,m.age) FROM Member m",UserDto.class).getResultList();
        for(UserDto dto : list) System.out.println(dto.getUsername()+" "+dto.getAge());*/
/*        List<Object[]> list = em1.createQuery("SELECT m.id,m.age FROM Member m").getResultList();
        for(Object[] o : list){
            Long id = (Long)o[0];
            int age = (int)o[1];
            System.out.println(id+" "+age);
        }*/
        /*
        Double orderAmg = em1.createQuery("SELECT AVG(o.orderAmount) FROM Order o",Double.class).getSingleResult();
        System.out.println(orderAmg);*/
       /* List<Address> list = em1.createQuery("SELECT o.address FROM Order o").getResultList();
        for(Address address : list ) System.out.println(address.getCity()+" "+address.getStreet()+" "+address.getZipcode())*/
        //List<Team> list = em1.createQuery("SELECT m.team FROM Member m WHERE m.id=?1").setParameter(1,5L).getResultList();
        //System.out.println(list.get(0).getId()+" "+list.get(0).getName());
/*        String usernameParam="최성훈";
        TypedQuery<Member> query = em1.createQuery("SELECT m from Member m where m.username = ?1",Member.class)
                                        .setParameter("username2",usernameParam)*/;
/*        query.setParameter("username2",usernameParam);
        List<Member> list = query.getResultList();
        System.out.println(list.size());*/
        /*String sql = "SELECT m.username,m.age FROM Member m";
        Query query = em1.createQuery(sql);
        //TypedQuery<Member> query = em1.createQuery(sql,Member.class);
        List list = query.getResultList();
        for(Object object : list){
            Object[] result = (Object [])object;
            System.out.println(result[0]+" "+result[1]);
        }*/
        //TypedQuery<Member> query = em1.createQuery("SELECT m FROM Member m",Member.class);
/*        Query query =em1.createQuery("SELECT m.username,m.age from Member m");
        List list = query.getResultList();
        for(Object o  : list){
            Object[] result = (Object[])o;
            System.out.println(result[0]);
        }*/
/*        String sql = "select id,name from member where name='kim'";
        List<Member> resultList = em1.createNativeQuery(sql,Member.class).getResultList();*/
        /*CriteriaBuilder cb = em1.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> m = query.from(Member.class);
        CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"),"kim"));
        List<Member> resultList = em1.createQuery(cq).getResultList();*/
        /*String jpql = "select m from Member as m where m.username='kim'";
        List<Member> resultList = em1.createQuery(jpql,Member.class).getResultList();*/
/*        Member2 member = em1.find(Member2.class,1L);
        member.setHomeAddress(new Address2("새로운도시","신도시1","123456"));
        Set<String> favoriteFoods = member.getFavoriteFodds();
        favoriteFoods.remove("탕수육");
        favoriteFoods.add("치킨");
        List<Address2> addressHistory = member.getAddressHistory();
        addressHistory.remove(new Address2("서울","기존 주소","123-123"));
        addressHistory.add(new Address2("새로운도시","새로운 주소","123-456"));*/
/*        Address2 addres = member.getHomeAddress();
        Set<String> favoriteFoods = member.getFavoriteFodds();
        for(String favoriteFood : favoriteFoods){
            System.out.println("favoriteFood = "+favoriteFood);
        }
        List<Address2> list = member.getAddressHistory();
        list.get(0);*/

/*
        Member2 member = new Member2();
        member.setHomeAddress(new Address2("통영","몽돌해수욕장","660-123"));
        member.getFavoriteFodds().add("짬뽕");
        member.getFavoriteFodds().add("짜장");
        member.getFavoriteFodds().add("탕수육");
        member.getAddressHistory().add(new Address2("서울","강남","123-123"));
        member.getAddressHistory().add(new Address2("서울","강북","000-000"));
        em1.persist(member);
*/

        /*Test test = new Test();
        PhoneServiceProvider phone = new PhoneServiceProvider("test");
        test.setPhoneServiceProvider(phone);

        PhoneServiceProvider phone2 = new PhoneServiceProvider(phone.getName());
        em1.persist(test);
*/
        /*Child child1 = new Child();
        Child child2 = new Child();
        Parent parent = new Parent();
        child1.setParent(parent);
        child2.setParent(parent);
        parent.getChildren().add(child1);
        parent.getChildren().add(child2);
        em1.persist(parent);*/

/*        Parent parent = new Parent();
        em1.persist(parent);
        Child child1 = new Child();
        child1.setParent(parent);
        em1.persist(child1);
        Child child2 = new Child();
        child2.setParent(parent);
        em1.persist(child2);*/


        /*Parent parent = new Parent(); //아래처럼 ParentId 객체를 생성 안해도 된다(persist시 자동으로 생성해서 영속성 컨텍스트에 저장함)
        parent.setId1("myId1");
        parent.setId2("myId2");
        parent.setName("parentName");
        em1.persist(parent);

        ParentId parentId = new ParentId("myId1","myId2"); // 당연히 조회시에는 이렇게 해야함
        Parent parent1 = em1.find(Parent.class,parentId);
        System.out.println(parent1.getId1()+" "+parent1.getId2());*/
        //EmbeddedId를 사용하는 클래스의 경우 키테이블 레퍼런스를 만들고 @IdClass처럼 사용해야 한다.(해당 클래스에 키를 키테이블 형식으로 저장했으므로)

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
