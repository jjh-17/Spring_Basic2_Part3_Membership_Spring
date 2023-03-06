package spring_basic2.part3_Membership_Spring.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part3_Membership_Spring.AppConfig;
import spring_basic2.part3_Membership_Spring.member.MemberService;
import spring_basic2.part3_Membership_Spring.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름과 타입으로 조회 - 인터페이스")
    void findBeanByName() {
        MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        System.out.println("[빈 이름과 타입으로 조회 - 인터페이스]");
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("빈 이름과 타입으로 조회 - 구현체")
    void findBeanByName2() {
        MemberServiceImpl memberServiceImpl = annotationConfigApplicationContext.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);

        System.out.println("[빈 이름과 타입으로 조회 - 구현체]");
        System.out.println("memberServiceImpl = " + memberServiceImpl);
        System.out.println("memberServiceImpl.getClass() = " + memberServiceImpl.getClass());
    }

    @Test
    @DisplayName("빈 이름과 타입으로 조회 실패")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> annotationConfigApplicationContext.getBean("xxxxx", MemberService.class));
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = annotationConfigApplicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        System.out.println("[이름 없이 타입으로만 조회]");
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회2")
    void findBeanByType2() {
        MemberService memberServiceImpl = annotationConfigApplicationContext.getBean(MemberServiceImpl.class);
        assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);

        System.out.println("[이름 없이 타입으로만 조회2]");
        System.out.println("memberServiceImpl = " + memberServiceImpl);
        System.out.println("memberServiceImpl.getClass() = " + memberServiceImpl.getClass());
    }
}
