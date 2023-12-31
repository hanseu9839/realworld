package com.realworld.project.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Member {
    private Long userSeq;
    private String userId;
    private String password;
    private String phoneNumber;
    private String userEmail;
    private LocalDateTime regDt;
    private LocalDateTime createDt;
    private String delYn;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    private String nickname;
    @Builder
    public Member(Long userSeq, String userId, String password,String phoneNumber, String userEmail, LocalDateTime regDt, LocalDateTime createDt, String delYn, Authority authority, String nickname){
        this.userSeq = userSeq;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.regDt = regDt;
        this.createDt = createDt;
        this.delYn = delYn;
        this.authority = authority;
        this.nickname = nickname;
    }

    @Builder
    public Member(Long userSeq, String userId, String password,String phoneNumber, String userEmail, LocalDateTime regDt, LocalDateTime createDt, String delYn, Authority authority){
        this.userSeq = userSeq;
        this.userId = userId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.regDt = regDt;
        this.createDt = createDt;
        this.delYn = delYn;
        this.authority = authority;
    }

}
