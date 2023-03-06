package spring_basic2.part3_Membership_Spring.discount;

import spring_basic2.part3_Membership_Spring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price); //할인 대상 금액 return
}
