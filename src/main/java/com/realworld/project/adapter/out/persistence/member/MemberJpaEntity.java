package com.realworld.project.adapter.out.persistence.member;

import com.realworld.project.domain.Authority;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Table(name="user")
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
@IdClass(MemberPK.class)
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Id
    private String userId;

    private String password;

    private String phoneNumber;

    private String userEmail;

    private String delYn;

    private String nickname;
    @LastModifiedDate
    private LocalDateTime regDt;

    @CreatedDate
    private LocalDateTime createDt;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public MemberJpaEntity(Long userSeq, String userId, String password,String phoneNumber, String userEmail, String delYn, LocalDateTime regDt, LocalDateTime createDt, Authority authority, String nickname){
        this.userSeq = userSeq;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.delYn = delYn;
        this.regDt = regDt;
        this.createDt = createDt;
        this.authority = authority;
        this.password = password;
        this.nickname = nickname;
    }

    @Builder
    public MemberJpaEntity(Long userSeq, String userId, String password,String phoneNumber, String userEmail, String delYn, LocalDateTime regDt, LocalDateTime createDt, Authority authority ){
        this.userSeq = userSeq;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.delYn = delYn;
        this.regDt = regDt;
        this.createDt = createDt;
        this.authority = authority;
        this.password = password;
    }

    @Builder
    public MemberJpaEntity(String userId, String phoneNumber, String userEmail, String delYn, LocalDateTime regDt, LocalDateTime createDt){
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.delYn = delYn;
        this.regDt = regDt;
        this.createDt = createDt;
    }
}
