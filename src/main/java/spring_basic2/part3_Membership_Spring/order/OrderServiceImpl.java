package spring_basic2.part3_Membership_Spring.order;

import spring_basic2.part3_Membership_Spring.discount.DiscountPolicy;
import spring_basic2.part3_Membership_Spring.member.Member;
import spring_basic2.part3_Membership_Spring.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    //변수
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //메서드
    @Override
    public Order createOrder(Long memberId, String productName, int productPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, productPrice);

        return new Order(memberId, productName, productPrice, discountPrice);
    }
}
