package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;
/*HTTP 요청 당 하나씩 생성
POST contruct를 통해 uuid 생성 저장
빈이 생성되는 시점에 requestURL을 알 수 있으므로(생성시 모름), setter 생성*/
@Component
@Scope(value = "request") // request scope인데, 스프링 컨테이너를 지금 시점에서 실행하면, request 요청이 없으니 해당 bean이 없음

public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean closed:" + this);

    }
}
