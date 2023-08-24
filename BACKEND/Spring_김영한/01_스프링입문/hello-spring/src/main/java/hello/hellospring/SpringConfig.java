package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private EntityManager em;
//    private MemberService memberService;

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }



//    @Bean
//    public MemberRepository memberRepository() {
//        return  new MemoryMemberRepository();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return  new JdbcMemberRepository(dataSource);
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }


}
