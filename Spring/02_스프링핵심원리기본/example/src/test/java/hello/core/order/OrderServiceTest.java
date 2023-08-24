package hello.core.order;

import hello.core.AppConfig_before;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig_before appConfig = new AppConfig_before();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

    @Test
    void fieldInjectionText() {
//        OrderServiceImpl orderService= new OrderServiceImpl();
        // 필드로 주입하면 , 생성자를 또 만들어서.. 난리가 나네.. 차라리 setter를 Autowired를 하는게 낫네
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        orderService.setDiscountPolicy(new FixDiscountPolicy());

//        orderService.createOrder(1L, "itemA", 10000);
    }

}
