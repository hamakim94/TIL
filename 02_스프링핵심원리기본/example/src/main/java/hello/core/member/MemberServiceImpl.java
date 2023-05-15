package hello.core.member;

public class MemberServiceImpl implements  MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository; // 이제 추상화에만 의존, 바깥 AppConfig에서 밖에서 넣어줌!

    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // 테스트 용도, 인터페이스까진 XX
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
