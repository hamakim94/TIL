package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean {

        // 스프링 컨테이너에서 관리하고 있지 않은 객체 -> 메서드 호출 자체가 안 돼, required=false 해서
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // nullable을 사용하면, 들어오는 대신 null
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // 자바8 옵셔널, empty로 반환해 줌
        @Autowired
        public void setNoBean3(Optional<Member>  noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
