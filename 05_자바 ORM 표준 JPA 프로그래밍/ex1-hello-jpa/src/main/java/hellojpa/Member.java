package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "USER") // 만약 테이블 명이 USER인 경우(DB)
public class Member {
    @Id
    private long id;
//    @Column(name = "user_name") // 만약 컬럼 명이 다른 경우
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
