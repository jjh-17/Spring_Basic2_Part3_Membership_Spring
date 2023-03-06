package spring_basic2.part3_Membership_Spring.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring_basic2.part3_Membership_Spring.discount.DiscountPolicy;
import spring_basic2.part3_Membership_Spring.member.MemberRepository;
import spring_basic2.part3_Membership_Spring.member.MemberService;

public class XmlAppContextTest {
    @Test
    @DisplayName("XML 기반 AppConfig")
    void xmlAppContext(){
        //given
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        //when
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        Assertions.assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);

        System.out.println("[XML 기반 AppConfig]");
        System.out.println("memberService = " + memberService);
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("memberRepository = " + memberRepository);
    }
}
