package spring_basic2.part3_Membership_Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic2.part3_Membership_Spring.discount.DiscountPolicy;
import spring_basic2.part3_Membership_Spring.discount.RateDiscountPolicy;
import spring_basic2.part3_Membership_Spring.member.MemberRepository;
import spring_basic2.part3_Membership_Spring.member.MemberService;
import spring_basic2.part3_Membership_Spring.member.MemberServiceImpl;
import spring_basic2.part3_Membership_Spring.member.MemoryMemberRepository;
import spring_basic2.part3_Membership_Spring.order.OrderService;
import spring_basic2.part3_Membership_Spring.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
