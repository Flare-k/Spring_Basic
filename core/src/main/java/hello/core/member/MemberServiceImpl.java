package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;    // 생성자 할당을 이용하므로 final을 써준다.

    // 생성자 주입: 구현체가 아닌 외부에 있는 AppConfig가 DI를 담당한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // 다형성에 의해서 MemoryMemberRepository에 있는 save가 호출된다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
