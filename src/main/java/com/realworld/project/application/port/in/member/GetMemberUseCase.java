package com.realworld.project.application.port.in.member;

import com.realworld.project.adapter.out.persistence.member.MemberJpaEntity;
import com.realworld.project.domain.Member;

import java.util.Optional;

public interface GetMemberUseCase {
    Optional<Member> findByUserId(String userId);
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserId(String userId);
    Member findByUserEmail(String userEmail);

}
