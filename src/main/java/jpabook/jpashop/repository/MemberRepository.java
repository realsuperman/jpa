package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:08
 */
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    //List<Member> findByName(String name);
    //List<Member> findByEmailAndName(String email,String name);
    //List<Member> findByUsername(@Param("username") String username);
    //@Query("select m from Member m where m.username = ?1")
    //Member findByUsername(String username);
    //@Query(value="SELECT * FROM MEMBER WHERE USERNAME=?0",nativeQuery = true) // 해당 Query는 네이티브 쿼리를 날린다(파라미터 순서는 0부터 시작한다)
    //Member findByUsername(String username);
    //@Query("select m from Member m where m.username=:name") //이름기반을 사용하는 경우 아래의 메소드에서 @Param이라는걸 명시해야 한다
    //Member findByUsername(@Param("name") String username);
    //@Modifying // 스프링 데이터 JPA에서 벌크성 수정,삭제 쿼리를 사용하겠다는 의미
    // 만약에 벌크성 쿼리를 날리고 영속성 컨텍스트를 초기화하고 싶으면 Modifying(clearAutomatically=true)로 하면 된다 기본값은 false임
    //@Query("update Product p set p.price=p.price*1.1 where p.stockAmount<:stockAmount")
    //int bulkPriceUp(@Param("stockAmount") String stockAmount);
    /*
    Page<Member> findByName(String name, Pageable pageable); // count 쿼리 사용
    List<Member> findByName(String name, Pageable pageable); // count 쿼리 미사용
    List<Member> findByName(String name, Sort sort);

     */
    Page<Member> findByNameStartingWith(String name,Pageable pageable);
}


/*
    spring data jap는 이름기반 및 위치기반 파라미터 바인딩을 제공한다 기본값은 위치기반이다 하지만 가독성을 위해서 이름기반을 사용하자

 */
