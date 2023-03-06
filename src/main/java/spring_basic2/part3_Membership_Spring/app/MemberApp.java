package spring_basic2.part3_Membership_Spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part3_Membership_Spring.AppConfig;
import spring_basic2.part3_Membership_Spring.member.Grade;
import spring_basic2.part3_Membership_Spring.member.Member;
import spring_basic2.part3_Membership_Spring.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        /*
        ApplicationContext : 스프링 컨테이너 겸 인터페이스
        XML 기반 혹은 '어노테이션 기반의 자바 설정 클래스'로 만들기 가능

        AppConfig.class : 구성정보
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
