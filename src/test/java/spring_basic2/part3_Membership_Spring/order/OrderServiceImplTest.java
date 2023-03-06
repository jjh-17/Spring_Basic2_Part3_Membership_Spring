package spring_basic2.part3_Membership_Spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_basic2.part3_Membership_Spring.AppConfig;
import spring_basic2.part3_Membership_Spring.member.Grade;
import spring_basic2.part3_Membership_Spring.member.Member;
import spring_basic2.part3_Membership_Spring.member.MemberService;

class OrderServiceImplTest {
    //변수
    MemberService memberService;
    OrderService orderService;

    //초기화
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    //테스트
    @Test
    void createVIPOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "productA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createBASICOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "productA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);
    }
}