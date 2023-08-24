package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {


    // 스프링 없이 직접 구현체를 넣어서 했다!!!! 생성자 주입의 장점장점
    // 심지어 파이널 키워드를 넣을 수 있음
    @Test
    void createOrder() {
        // 만약 setter로 설정하면, 아래 코드에서 에러가 안 뜸.(가운데에 new new 없어서~)
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP))
        ;
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());// 어라, 누락이 됐네
        // 컴파일 오류가 자동으로 난다..!!!!

        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}