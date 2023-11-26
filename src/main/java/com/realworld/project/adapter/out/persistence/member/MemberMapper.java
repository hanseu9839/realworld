package com.realworld.project.adapter.out.persistence.member;

import com.realworld.project.domain.Member;
import org.springframework.stereotype.Component;


@Component
public class MemberMapper {
    public Member toDomain(MemberJpaEntity entity){
        return Member.builder()
                    .userId(entity.getUserId())
                    .userEmail(entity.getUserEmail())
                    .phoneNumber(entity.getPhoneNumber())
                    .createDt(entity.getCreateDt())
                    .regDt(entity.getRegDt())
                    .delYn(entity.getDelYn())
                    .authority(entity.getAuthority())
                    .build();
    }

    public MemberJpaEntity toEntity(Member domain){
        return MemberJpaEntity.builder()
                            .userId(domain.getUserId())
                            .userEmail(domain.getUserEmail())
                            .password(domain.getPassword())
                            .phoneNumber(domain.getPhoneNumber())
                            .createDt(domain.getCreateDt())
                            .regDt(domain.getRegDt())
                            .delYn(domain.getDelYn())
                            .authority(domain.getAuthority())
                            .build();
    }
}
