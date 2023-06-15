package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "USER") // 만약 테이블 명이 USER인 경우(DB)
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
