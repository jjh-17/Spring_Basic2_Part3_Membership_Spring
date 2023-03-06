package spring_basic2.part3_Membership_Spring.member;

public class MemberServiceImpl implements MemberService{
    //변수
    private final MemberRepository memberRepository;

    //생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        //MemberRepository의 구현체 중 하나로 초기화 ==> DIP 준수
        this.memberRepository = memberRepository;
    }

    //메서드
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
