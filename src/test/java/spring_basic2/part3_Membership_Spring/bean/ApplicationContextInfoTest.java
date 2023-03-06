package spring_basic2.part3_Membership_Spring.bean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part3_Membership_Spring.AppConfig;

/*
스프링 컨터이너에 속한 스프링 빈 정보를 조회하여 테스트
 */
public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void printEveryBean() {
        //getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름 조회
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println("[모든 빈 출력]");

        //iter 후 enter를 하면 자동 for문 완성
        for(String beanDefinitionName : beanDefinitionNames) {
            //getBean(빈 이름, 타입) : 빈 이름으로 빈 객체(인스턴스) 조회(타입은 없어도 됨)
            //조회 대상
            Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " / object = " + bean);
        }
        System.out.println();
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void printApplicationBean(){
        String[] beanDeficitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println("[어플리케이션 빈 출력]");

        for(String beanDefinitionName : beanDeficitionNames){
            BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " / object = " + bean);
            }
        }
    }

    @Test
    @DisplayName("인프라 빈 출력하기")
    void printInfraStructureBean(){
        String[] beanDeficitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println("[인프라 빈 출력]");

        for(String beanDefinitionName : beanDeficitionNames){
            BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition(beanDefinitionName);

            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " / object = " + bean);
            }
        }
    }
}
