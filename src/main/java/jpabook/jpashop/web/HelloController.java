package jpabook.jpashop.web;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    public void hello(){
        Member member = helloService.logic();
    }
}
