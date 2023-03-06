package spring_basic2.part3_Membership_Spring.member;

public interface MemberRepository {
    void save(Member member);       //회원 정보 저장
    Member findById(Long memberId); //회원 검색
}
