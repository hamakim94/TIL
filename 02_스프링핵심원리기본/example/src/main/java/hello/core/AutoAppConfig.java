package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // appConfig 자동 등록하는거 충돌 방지하기 위해 만들었따. 기존 코드를 남기기 위해 해당 방법 선택
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


    @Bean(name = "memoryMemberRepository") // 증복을 위해 이렇게 설정
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
