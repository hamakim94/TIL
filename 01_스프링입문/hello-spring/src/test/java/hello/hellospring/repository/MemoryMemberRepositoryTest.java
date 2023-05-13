package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 콜백 메서드같은거라고, 공용데이터 깔끔하게 지워주기.. callback마냥 샥샥 지워질 수 있따.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional에서 값 가져올떈 get
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // option + enter : import, static class import 가능


    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

        // 실무에서는 build랑 엮여서 틀리면 빌드 못하게 막아버림


    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }

    // 모든 테스트는 순서와 관련 없어야 한다.
    // findAll 부터 실행하면 여기서 이미 객체를 만들어 저장하므로
    // findByName 했을 때 다른 객체가 나와서 error


}
