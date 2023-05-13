package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl(); 이제 앱config에서 할거야
        // before spring
//        AppConfig_before appConfig = new AppConfig_before();
//        MemberService memberService = appConfig.memberService(); // 이제 여기에서 놀아!!

        // after spring
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 기본적으로 이름은 메서드로

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());


    }
}
