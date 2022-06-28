package jpabook.jpashop.web;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 4. Time: 오후 9:07
 */
@Controller
public class MemberController {

    @Autowired MemberService memberService;
    @Autowired ItemService itemService;
    @Autowired MemberRepository memberRepository;

    @RequestMapping(value = "/members/new", method = RequestMethod.GET)
    public String createForm() {
        return "members/createMemberForm";
    }

    @RequestMapping(value = "/members/new", method = RequestMethod.POST)
    public String create(Member member, String city, String street, String zipcode) {

        Address address = new Address(city, street, zipcode);
        member.setAddress(address);
        memberService.join(member);
        return "redirect:/";
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String list(Model model) {

        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

/*    @RequestMapping("member/memberUpdateForm")
    public String memberUpdateForm(@RequestParam("id") Long id,Model model){
        Member member = memberRepository.findOne(id);
        model.addAttribute("member",member);
        return "member/memberSaveForm";
    }*/

    @RequestMapping("mamber/memberUpdateForm")
    public String memberUpdateForm(@RequestParam("id") Member member,Model model){
        model.addAttribute("member",member);
        return "member/memberSaveForm";
    }
    /*  위의 메소드에서 id를 Long id로 받는게 아니라 id를 Member 개체로 받고 있다 이런경우 중간에 도메인 클래스 컨버터가 id를 가지고
        Member개체를 조회한다(엔티티와 관련된 레포지토리를 조사함) 여기서는 회원 리포지토리를 통해서 회원이이디로 회원 엔티티를 찾는다
        참고로 member라는걸 아래에서 사용할 순 있지만 이건 준영속이기 때문에 변경 감지기능이 동작하지 않는다 만약 하고 싶으면 merge를 사용하거나
        OSIV를 사용하면 된다

     */
}
