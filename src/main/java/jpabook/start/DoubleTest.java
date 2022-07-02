package jpabook.start;


import antlr.StringUtils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryModifiers;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.h2.engine.User;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static <T> T unproxy(Object entity){
        if(entity instanceof HibernateProxy) {
            entity = ((HibernateProxy) entity)
                    .getHibernateLazyInitializer()
                    .getImplementation();
        }
        return (T) entity;
    }
    public static void main(String[] args) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Book saveBook = new Book();
        saveBook.setName("jpabook");
        saveBook.setAuthor("kim");
        em.persist(saveBook);
        tx.begin();
        em.flush();
        em.clear();
        Item proxyItem = em.getReference(Item.class,saveBook.getId());
        Item unProxyItem =  unproxy(proxyItem);
        if(unProxyItem instanceof Book){
            Book book = (Book)unProxyItem;
            System.out.println(book.getAuthor());
        }
/*        Member member = new Member();
        member.setName("csh");
        em.persist(member);
        Member test = em.find(Member.class,37L);
        em.clear();
        if(test==member) System.out.println("true");*/
/*        EntityGraph<Order> graph = em.createEntityGraph(Order.class);
        graph.addAttributeNodes("member");
        Subgraph<OrderItem> orderItems = graph.addSubgraph("orderItems");
        orderItems.addAttributeNodes("item");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph",graph);
        Order order = em.find(Order.class,1L,hints);*/
/*        EntityGraph<Order> graph = em.createEntityGraph(Order.class);
        graph.addAttributeNodes("member");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph",graph);
        Order order = em.find(Order.class,1,hints);*/
        //List<Order> list = em.createQuery("select o from Order o where o.id=:orderId",Order.class).setParameter("orderId",1L).setHint("javax.persistence.fetchgraph",em.getEntityGraph("Order.withAll")).getResultList();
        //EntityGraph graph = em.getEntityGraph("Order.withAll");
/*        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph",em.getEntityGraph("Order.withAll"));
        Order order = em.find(Order.class,1L,hints);*/
/*
        EntityGraph graph = em.getEntityGraph("Order.withMember");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph",graph);
        Order order = em.find(Order.class,1L,hints);
*/
/*        Duck duck = new Duck();
        duck.setName("csh");
        em.persist(duck);
        tx.begin();
        tx.commit();*/
/*        Test test = new Test();
        test.setUsername("최성훈");
        test.setVip(true);
        em.persist(test);
        tx.begin();
        tx.commit();
        Test t = em.find(Test.class,1L);
        System.out.println(t.isVip());*/
        //Order order = em.find(Order.class,1L);
        //List<Order> order = em.createQuery("select o from Order o join fetch o.member join fetch o.delivery",Order.class).getResultList();

/*        em.setFlushMode(FlushModeType.COMMIT);
        tx.begin();
        Product proudct1 = em.find(Product.class,1L);
        proudct1.setPrice(1200);
        //em.flush();
        Product product2 = em.createQuery("SELECT p FROM Product p WHERE p.price=1200",Product.class).setFlushMode(FlushModeType.AUTO).getSingleResult();
        System.out.println(product2.getName());
        tx.commit();*/
/*        Product productA = em.createQuery("select p from Product p where p.name=:name",Product.class).setParameter("name","치즈").getSingleResult();
        System.out.println("치즈 수정전 = "+productA.getPrice());
        tx.begin();
        em.createQuery("update Product p set p.price=p.price*1.1").executeUpdate();
        tx.commit();
        em.refresh(productA);
        System.out.println("치즈 수정후 = "+productA.getPrice());*/
        /*
           String sql = "update Product p set p.price=p.price*1.1 where p.stockAmount<:stockAmount";
        tx.begin();
        em.createQuery(sql).setParameter("stockAmount",1100).executeUpdate();
        tx.commit();*/
        //List<Object[] >list = em.createNamedQuery("Member.memberWithOrderCount").getResultList();
        //System.out.println(list.size());
/*
        List<Member> list  = em.createNamedQuery("memberSQL").setParameter(1,20).getResultList();
*/
        //em.createNativeQuery("memberSQL").setParameter(1,10);
        //List<Member> nativeQuery = em.createNativeQuery("Member.memberSQL",Member.class).setParameter(1,20).getResultList();
        //for(Member member : nativeQuery) System.out.println(member.getUsername());
        //Query query = em.createNativeQuery("SELECT o.id AS order_id, o.quantity AS order_quantity, o.item AS order_item, i.name AS item_name FROM Order o,Item i WHERE (order_quantity>25) AND (order_item=i.id)","OrderResults");

/*        String sql = "SELECT M.ID, AGE, NAME, TEAM_ID, I.ORDER_COUNT "+
                "FROM MEMBER M "+
                "LEFT JOIN "+
                " (SELECT IM.ID, COUNT(*) AS ORDER_COUNT "+
                " FROM ORDERS O, MEMBER IM "+
                " WHERE O.MEMBER_ID = IM.ID GROUP BY IM.ID) I "+
                "ON M.ID=I.ID";
        Query nativeQuery = em.createNativeQuery(sql,"memberWithOrderCount");
        List<Object[] > list = nativeQuery.getResultList();
        for(Object[] row : list){
            Member member = (Member) row[0];
            BigInteger orderCount = (BigInteger)row[1];
            System.out.println("member = "+member);
            System.out.println("orderCount = "+orderCount);
        }*/
/*        String sql = "SELECT ID,AGE,NAME,TEAM_ID FROM MEMBER WHERE AGE>? AND NAME LIKE '%?%'";
        List<Member> list  = em.createNativeQuery(sql,Member.class)
                .setParameter(1,20)
                .setParameter(2,"최")
                .getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
/*        JPAQueryFactory query = new JPAQueryFactory(em);
        QMember member = QMember.member;
        String name = "최성훈";
        List<Member> list = query.selectFrom(member).where(nameEq(member,name)).fetch();
        for(Member mem : list) System.out.println(mem.getUsername());*/
        //query.selectFrom(member).where()
        //QProduct product = QProduct.product;
        //JPAUpdateClause updateClause = new JPAUpdateClause(em,product);
        //JPADeleteClause deleteClause = new JPADeleteClause(em,product);

        //tx.begin();
        //deleteClause.where(product.name.eq("치즈2")).execute();
        //long count = updateClause.where(product.name.eq("치즈")).set(product.price,10000).execute();
        //tx.commit();
        /*List<ItemDTO> list = query.from(product).
                fetch(Projections.constructor(ItemDTO.class,product.name.as("username"),product.price));
*/        //QProduct product = QProduct.product;
        //QMember member = QMember.member;
        //List<Tuple> list = query.select(member.username, member.age).from(member).fetch();
        /*for(Tuple tuple : list){
            int price = tuple.get(Product.price);
            String name = tuple.get(Product.name);
            System.out.println(name+" "+price);
        }*/
/*        QProduct qProduct2 = new QProduct("product");
        List<Product> list = query.selectFrom(qProduct1)
                .where(qProduct1.in(
                        JPAExpressions.selectFrom(qProduct2).where(qProduct2.name.eq("족발대"))
                ))*/
                /*.where(qProduct1.price.eq(
                JPAExpressions.select(qProduct2.price.max()).from(qProduct2)
        ))*/
        //.fetch();
/*        QOrder order = QOrder.order;
        QMember member = QMember.member;
        List<Order> list = query.select(order).from(order,member).where(order.member.eq(member)).fetch();*/
/*        QOrder qOrder = QOrder.order;
        QMember qMember = QMember.member;
        QProduct qProduct = QProduct.product;
        List<Order> list = query.selectFrom(qOrder)
                        .join(qOrder.member,qMember).fetchJoin()
                        .leftJoin(qOrder.product,qProduct)
                        .on(qOrder.product.price.gt(1000000))
                        .on(qOrder.id.eq(3L))
                        .fetch();
        for(Order order : list ) System.out.println(order.getProduct().getId());*/
        //QProduct qProduct = new QProduct("p");
        //QueryModifiers queryModifiers = new QueryModifiers(20L,1L);
/*        List<Product> list = query
            .select(qProduct)
            .from(qProduct)
            .groupBy(qProduct.name)
            .having(qProduct.price.gt(10000))
            .fetch();*/
            //.where(qProduct.price.gt(20000))
            //.orderBy(qProduct.price.desc(),qProduct.stockAmount.asc())
            //.restrict(queryModifiers)
            //.offset(0).limit(20)
        //for(Product product : list) System.out.println(product.getName());
/*        QProduct product = QProduct.product;
        List<Product> list =queryFactory.selectFrom(product)
                .where(product.name.eq("치즈").and(product.price.gt(500)).and(product.price.between(10,5000))).fetch();
        for(Product pro : list) System.out.println(pro.getName());*/
        //QMember qMember = new QMember("m"); // 같은 테이블을 다른 개체로 봐야 하는 경우 이렇게 생성함
/*        QMember qMember = QMember.member; // 하나의 개체만 사용하는 경우 이런식으로 기본 인스턴스 사용 가능함
        List<Member> list = queryFactory.selectFrom(qMember).fetch();
        for(Member member : list) System.out.println(member.getUsername());*/
        //query.fetch();
        /*List<Member> members =  query.from(qMember)
                                .where(qMember.username.eq("최성훈"))
                                .orderBy(qMember.username.desc())*/


        //EntityTransaction tx = em.getTransaction();
        //tx1.begin();
/*        JPAQuery query = new JPAQuery(em1);*/
/*        QMember qMember = new QMember("m");*/
/*        CriteriaBuilder cb = em1.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> root = query.from(Member.class);
        query.select(root);
        query.where(cb.equal(root.get("username"),cb.parameter(String.class,"username")));
        List<Member> list = em1.createQuery(query).setParameter("username","최성훈").getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
/*        Root<Member> root = query.from(Member.class);

        Subquery<Double> subQuery = query.subquery(Double.class);
        Root<Member> root2 = subQuery.from(Member.class);
        subQuery.select(cb.avg(root2.get("age")));

        query.where(cb.ge(root.get("age"),subQuery));
        List<Member> list = em1.createQuery(query).getResultList();
        for(Member member : list ) System.out.println(member.getUsername());*/
/*        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Member> root = query.from(Member.class);
        Join<Member,Team> team = root.join("team");
        query.where(cb.equal(team.get("name"),"LG"));
        query.multiselect(root,team);
        List<Object[]> list = em1.createQuery(query).getResultList();
        for(Object[] obj : list){
            Member member = (Member)obj[0];
            Team t = (Team)obj[1];
            System.out.println(member.getUsername()+" "+t.getName());
        }*/
/*        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Member> root = query.from(Member.class);
        query.multiselect(
            root.get("team").get("name"),
            cb.max(root.get("age")),
            cb.min(root.get("age"))
        );
        query.groupBy(root.get("team").get("name"));
        List<Object[]> list = em1.createQuery(query).getResultList();
        for(Object[] obj : list) System.out.println((String)obj[0]+" "+(int)obj[1]+" "+(int)obj[2]);*/
        //CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
/*        CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<Member> root = query.from(Member.class);
        query.multiselect(
                root.get("age").alias("age"),
                root.get("username").alias("username")
        ).distinct(true);
        query.where(cb.gt(root.get("age"),30));
        query.orderBy(cb.desc(root.get("age")));
        List<Tuple> list = em1.createQuery(query).getResultList();
        for(Tuple tuple : list){
            int age = tuple.get("age",Integer.class);
            String userName = tuple.get("username",String.class);
            System.out.println(age+" "+userName);
        }*/
        //List<Object[]> list = em1.createQuery(query).getResultList();
        //for(Object[] obj : list) System.out.println((int)obj[0]+" "+(String)obj[1]);
/*        query.where(cb.equal(root.get("username"),"최성훈"));
        query.orderBy(cb.desc(root.get("age")));*/
/*
        Integer age = null;
        String username = null;
        String teamName = "SKT";
        CriteriaBuilder cb = em1.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
        Join<Member,Team> t = m.join("team");
        List<Predicate> criteria = new ArrayList<>();
        if(age!=null) criteria.add(cb.equal(m.get("age"),cb.parameter(Integer.class,"age")));
        if(username!=null) criteria.add(cb.equal(m.get("username"),cb.parameter(String.class,"username")));
        if(teamName!=null) criteria.add(cb.equal(t.get("name"),cb.parameter(String.class,"teamName")));
        cq.where(cb.and(criteria.toArray(new Predicate[0])));
        TypedQuery<Member> query = em1.createQuery(cq);
        if(age!=null) query.setParameter("age",age);
        if(username!=null) query.setParameter("username",username);
        if(teamName!=null) query.setParameter("teamName",teamName);
        List<Member> list = query.getResultList();
        for(Member member : list) System.out.println(member.getUsername());
*/


/*        Integer age = null;
        String username = null;
        String teamName = "SKT";
        StringBuilder jpql = new StringBuilder("select m from Member m join m.team t");
        List<String> criteria = new ArrayList<>();
        if(age!=null) criteria.add(" m.age=:age ");
        if(username!=null) criteria.add(" m.username=:username ");
        if(teamName!=null) criteria.add(" t.name=:teamName ");
        if(criteria.size()>0) jpql.append(" where ");
        for(int i=0;i<criteria.size();i++){
            if(i>0) jpql.append(" and ");
            jpql.append(criteria.get(i));
        }
        TypedQuery<Member> query = em1.createQuery(jpql.toString(),Member.class);
        if(age!=null) query.setParameter("age",age);
        if(username!=null) query.setParameter("username",username);
        if(teamName!=null) query.setParameter("teamName",teamName);
        List<Member> list = query.getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
        /*
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
*/
/*        Expression<Long> function = cb.function("SUM",Long.class,m.get("age"));
        cq.select(function);*/
/*
        cq.select(m);
        cq.where(cb.equal(m.get("username"),cb.parameter(String.class,"usernameParam")));
        List<Member> list = em1.createQuery(cq).setParameter("usernameParam","최성훈").getResultList();
        for(Member member : list) System.out.println(member.getUsername());
*/
/*        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Member> root = query.from(Member.class);
        query.multiselect(
          root.get("username"),
          cb.selectCase()
                .when(cb.ge(root.get("age"),40),600)
                .when(cb.le(root.get("age"),15),500)
                .otherwise(1000)
        );
        List<Object[]> list = em1.createQuery(query).getResultList();
        for(Object[]  obj: list ){
            String name = (String)obj[0];
            int value = (int)obj[1];
            System.out.println(name+" "+value);
        }*/
/*        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> root = query.from(Member.class);
        Join<Member,Team> t = root.join("team",JoinType.INNER);
        query.select(root);
        query.where(cb.equal(t.get("id"),1));
        List<Member> list = em1.createQuery(query).getResultList();
        for(Member member : list) System.out.println(member.getUsername());*/
/*        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
        cq.select(m).where(cb.in(m.get("username")).value("최성훈"));
        List<Member> list = em1.createQuery(cq).getResultList();
        for(Member member : list){
            System.out.println(member.getUsername());
        }*/
/*        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);
        Root<Member> m = mainQuery.from(Member.class);

        Subquery<Team> subQuery = mainQuery.subquery(Team.class);
        Root<Member> subM = subQuery.correlate(m);
        Join<Member,Team> t = subM.join("team");
        subQuery.select(t).where(cb.equal(t.get("name"),"SSG"));
        mainQuery.select(m).where(cb.exists(subQuery));
        List<Member> list = em1.createQuery(mainQuery).getResultList();
        for(Member member : list ) System.out.println(member.getUsername());*/
/*        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Subquery<Double> subQuery = query.subquery(Double.class);

        Root<Member> m2 = subQuery.from(Member.class);
        subQuery.select(cb.avg(m2.get("age")));
        Root<Member> m = query.from(Member.class);
        query.select(m);
        query.where(cb.ge(m.get("age"),subQuery));
        List<Member> list = em1.createQuery(query).getResultList();
        for(Member member : list ) System.out.println(member.getUsername());*/
/*        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Member> m = query.from(Member.class);
        Join<Member,Team> t = m.join("team",JoinType.INNER);
        query.multiselect(m,t);
        query.where(cb.equal(t.get("name"),"SSG"));
        List<Object[]> list = em1.createQuery(query).getResultList();
        for(Object[] obj : list){
            Member member = (Member) obj[0];
            Team team = (Team)obj[1];
            System.out.println(member.getUsername()+" "+team.getName());
        }*/
/*        CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<Member> m = query.from(Member.class);
        query.groupBy(m.get("team").get("name"));
        query.having(cb.greaterThan(cb.max(m.get("age")),30));
        query.multiselect(
            m.get("team").get("name").alias("teamName"),
            cb.max(m.get("age")).alias("maxAge"),
            cb.min(m.get("age")).alias("minAge")
        );
        List<Tuple> list = em1.createQuery(query).getResultList();
        for(Tuple tuple : list ){
            String name = tuple.get("teamName",String.class);
            int maxAge = tuple.get("maxAge",Integer.class);
            int minAge = tuple.get("minAge",Integer.class);
            System.out.println(name+" "+minAge+" "+maxAge);
        }*/
/*        query.multiselect(
                m.alias("m"),
                m.get("username").alias("username"),
                m.get("age").alias("age")
        );
        List<Tuple> list = em1.createQuery(query).getResultList();
        for(Tuple tuple : list){
            Member member = tuple.get("m",Member.class);
            String username = tuple.get("username",String.class);
            Integer age = tuple.get("age",Integer.class);
            System.out.println(member.getId()+username+" "+age);
        }*/
/*        query.select(cb.construct(UserDto.class,m.get("username"),m.get("age")));
        List<UserDto> list = em1.createQuery(query).getResultList();
        for(UserDto dto : list) System.out.println(dto.getUsername());*/
/*        query.multiselect(m.get("username"),m.get("age")).distinct(true); // 뒤에 distinct키워드가 붙는다
        List<Object[]>  list = em1.createQuery(query).getResultList();
        for(Object[] obj : list) System.out.println((String)obj[0]+" "+(int)obj[1]);*/
        //query.multiselect(m.get("age"),m.get("username"));
        //query.select(cb.array(m.get("age"),m.get("username")));
        //query.where(cb.greaterThan(m.get("age"),40));
        //query.where(cb.equal(m.get("username"),"최성훈"));
        //query.orderBy(cb.desc(m.get("age")));
        //List<Object[]> list = em1.createQuery(query).getResultList();
        //for(Object[] obj: list) System.out.println((int)obj[0]+" "+(String)obj[1]);
/*        List<Team> list = em1.createQuery("SELECT t FROM Team t JOIN t.member m WHERE t.id=1").getResultList();
        for(Team t : list) System.out.println(t.getName());*/
/*        CriteriaBuilder cb = em1.getCriteriaBuilder();

        CriteriaQuery<Member> m = cb.createQuery(Member.class);
        Root<Member> root = m.from(Member.class);
        m.select(root);
        m.where(cb.greaterThan(root.get("age"),10));
        m.orderBy(cb.desc(root.get("age")));
        List<Member> list = em1.createQuery(m).getResultList();
        for(Member member: list) System.out.println(member.getUsername());*/
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
        //tx1.commit();
        //em1.close();
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
