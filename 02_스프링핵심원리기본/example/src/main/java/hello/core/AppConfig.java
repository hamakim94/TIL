package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository
    //@Bean orderService -> new MemoryMemberRepository, 분명 new가 여러갠데, 싱글톤 깨지는거 아냐?
    // 그럴 떈 테스트 코드로 시험해보

    // @configuration 싱글톤
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository -> 3번 호출되는게 정상 아님?
    //-------현실------------- => !!?!?!
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService


    // 기존에는 Impl에서 직접 정해줬지만, 이제 AppConfig라는 클래스에서 하기로 했다.
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    // 근데 사실 어떤 역할인지 보여아 하는데, 전혀 안 보인다

    // 기존에는 함수 안에 new new 이렇게 됐는데, 매우 귀찮다.
    // disCountPolicy() 이라는 함수를 만들어서

}
