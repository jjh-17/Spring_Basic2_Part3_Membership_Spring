package spring_basic2.part3_Membership_Spring.discount;

import spring_basic2.part3_Membership_Spring.member.Grade;
import spring_basic2.part3_Membership_Spring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    //변수
    private int fixedDiscountAmount = 1000;

    //메서드
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return fixedDiscountAmount;
        }
        return 0;
    }
}
