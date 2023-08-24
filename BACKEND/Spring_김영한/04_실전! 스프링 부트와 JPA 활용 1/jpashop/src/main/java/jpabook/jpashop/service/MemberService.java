package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 기본적으로, 데이터 변경하는건 트랜잭셔널~
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository; // fianl : requiredArgsConstructor 이용!

    // 핵심 기능 2개

    /**
     * 회원 가입
     */
    @Transactional // 여긴 readOnly 안 돼
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
        // 만약 memberA 동시에 하면, 이 로직을 통과하게 된다면, 회원가입 된다
        // 멀티스레드, DB에 unique 제약조건. 굳
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
