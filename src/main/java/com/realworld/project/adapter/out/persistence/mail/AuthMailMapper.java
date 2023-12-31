package com.realworld.project.adapter.out.persistence.mail;

import com.realworld.project.domain.AuthMail;
import org.springframework.stereotype.Component;

@Component
public class AuthMailMapper {
    public AuthMail toDomain(AuthMailJpaEntity entity){
        return AuthMail.builder()
                        .userEmail(entity.getUserEmail())
                        .authNumber(entity.getAuthNumber())
                        .regDt(entity.getRegDt())
                        .build();
    }

    public AuthMailJpaEntity toEntity(AuthMail authMail){
        return AuthMailJpaEntity.builder()
                                .userEmail(authMail.getUserEmail())
                                .authNumber(authMail.getAuthNumber())
                                .regDt(authMail.getRegDt())
                                .build();
    }
}
