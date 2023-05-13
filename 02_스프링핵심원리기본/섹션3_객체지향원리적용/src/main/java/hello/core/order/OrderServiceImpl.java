package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements  OrderService{


    // private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private DiscountPolicy discountPolicy = new RateDiscountPolicy(); // OrderServiveImpl 코드를 바꾸는 순간 OCP 위반
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 이렇게 하면 추상화된 인터페이스만 의존하도록 설계했음!

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
