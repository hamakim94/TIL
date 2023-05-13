package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig_before {

    // 기존에는 Impl에서 직접 정해줬지만, 이제 AppConfig라는 클래스에서 하기로 했다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    // 근데 사실 어떤 역할인지 보여아 하는데, 전혀 안 보인다

    // 기존에는 함수 안에 new new 이렇게 됐는데, 매우 귀찮다.
    // disCountPolicy() 이라는 함수를 만들어서

}
