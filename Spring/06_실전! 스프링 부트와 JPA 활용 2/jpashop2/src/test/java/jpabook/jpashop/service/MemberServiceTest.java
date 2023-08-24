package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨테이너 안에서 테스트 돌리겠다!
@Transactional // 이게 있어야 rollback 가능
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepository;

//    @Autowired
//    EntityManager entityManager;

    @Test
//  @Rollback(value = false) 실제 DB에 들어가는걸 확인하기 위해, 이런 옵션을 주면 된다
    // 기본적으로 테스트에서 Transactional 돌리면 RollBack하기 떄문에 바로 반영이 안 된다.
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        // em.flush() : 영속성 context를 db에 반영, insert가 들어감
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test// Junit4에선 여기에 expected 옵션이 있어서 어떤 에러가 나는지 넣으면 된다!
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        //when
        memberService.join(member1);
        try {
            memberService.join(member2); // 예외가 발생해야 함!!!!!

        } catch (IllegalStateException e) {
            return;
        }

        //then
        fail("예외가 발생해야 한다"); // 여기로 오면 안 된다..!!

    }
}