package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void configurationDeep() {
		//AppConfig도 스프링 빈으로 등록된다
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);
		//출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70
		System.out.println("bean = " + bean.getClass());
	}
}
