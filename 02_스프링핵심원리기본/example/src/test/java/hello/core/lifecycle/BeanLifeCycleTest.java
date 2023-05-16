package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // 기존 ApplicationContext는 먾은 기능이 없음, 추가 기능을 원하려면 하위까지 내려가야지 제공하는 기능
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean("networkClient", NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        // 외부에서 사용하는 서비스를 Bean으로 등록했는데, 끝내고 싶지 않으면 distoryMethod = "")
        // 공백으로 지정해주면 된다. 왜냐면 Bean 자체에서 destroyMethod는 추론하기 떄문이다.
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
