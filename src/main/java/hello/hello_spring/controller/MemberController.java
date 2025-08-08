package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    //생성자 주입 ... 제일 좋은 의존성 주입 방법
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    /*//필드 주입 방법.. 비추
    @Autowired private MemberService memberService;
    */

    /*// setter 주입 .. public 으로 노출됨
    @Autowired
    public void setMemberService(MemberService memberService)
    {
        this.memberService=memberService;
    }*/


}
