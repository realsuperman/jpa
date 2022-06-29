package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.Repository1;
import jpabook.jpashop.repository.Repository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class HelloService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    Repository1 repository1;
    @Autowired
    Repository2 repository2;
    @Transactional
    public Member logic(){
        repository1.hello();
        Member member = repository2.findMember();
        return member;
    }

}
