package jpabook.jpashop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Repository1 {
    @PersistenceContext
    EntityManager em;
    public void hello(){
        //em.xxx();
    }
}
