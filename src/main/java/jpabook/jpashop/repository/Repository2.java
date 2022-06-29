package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Repository2 {
    @PersistenceContext
    EntityManager em;
    public Member findMember(){
        return em.find(Member.class,"id1");
    }
}
