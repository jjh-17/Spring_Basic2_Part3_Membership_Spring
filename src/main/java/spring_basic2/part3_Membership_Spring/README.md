[스프링 컨테이너 구조]
interface - BeanFactory
        |
interface - ApplicationContext
        |
AnnotationConfig - ApplicationContext


[BeanFactory]
-스프링 컨테이너의 최상위 인터페이스
-스프링 빈 관리 및 조회
-getBean() 제공

[ApplicationContext]
-BeanFactory 기능을 모두 상속받아 제공
-빈 관리/조회 기능 외에 다른 부가기능 제공
        ==> EX) MassageSource, EnvironmentCapable, ApplicationEventPublisher, ResourceLoader


[스프링 컨테이너의 설정 형식]
<어노테이션 기반 자바 코드>
new AnnotationConfigApplicationContext(AppConfig.class)

<XML>
GenericXmlApplicationContext를 사용하여 xml 설정 파일을 넘긴다.

<Groovy>


[스프링 빈 설정 메타 정보 - BeanDefinition]







