package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args){
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // 스프링 코드, 스프링은 AppConfig를 가지고 Bean이 붙은 객체 인스턴스를 스프링컨테이너에 등록하고 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig 에서 memberService 이름을 갖고 있는 Bean을 MemberService.class 에서 찾을 거야
        // -> 이때, Bean은 참조하고 있는 구현 객체? 인 것 같음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 등록한 사람이 가입되는지 확인하기
        Member findMember = memberService.findMember(1L);
        System.out.println("new member =" + member.getName());
        System.out.println("find member =" + findMember.getName());
    }
}
