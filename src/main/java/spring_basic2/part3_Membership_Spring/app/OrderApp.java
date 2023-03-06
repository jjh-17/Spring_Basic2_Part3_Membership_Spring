package spring_basic2.part3_Membership_Spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part3_Membership_Spring.AppConfig;
import spring_basic2.part3_Membership_Spring.member.Grade;
import spring_basic2.part3_Membership_Spring.member.Member;
import spring_basic2.part3_Membership_Spring.member.MemberService;
import spring_basic2.part3_Membership_Spring.order.Order;
import spring_basic2.part3_Membership_Spring.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
