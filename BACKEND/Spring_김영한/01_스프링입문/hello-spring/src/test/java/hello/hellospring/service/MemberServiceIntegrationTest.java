package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // Test에서 트랜잭션을 달면 롤백을 그냥 해줌!
class MemberServiceIntegrationTest {

    // 실제 코드는 setter 기반으로 많이 하지만
    // 테스트는 크게 중요하지 않아, 제일 끝단에서 하는 작업이기 때문에
    // 필드 기반으로 DI 해서 자원들을 활용한다
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    // 테스트만큼은 한글로도 많이 작성한다
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
       /* try{
            memberService.join(member2);
            fail();
        } catch( IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        }*/


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}