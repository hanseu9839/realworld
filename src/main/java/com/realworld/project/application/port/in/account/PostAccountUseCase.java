package com.realworld.project.application.port.in.account;

import com.realworld.project.application.port.in.dto.MemberDTO;
import com.realworld.project.domain.Member;

public interface PostAccountUseCase {
    void updatePassword(MemberDTO memberDto, String userId);
    long updateEmail(String userId, MemberDTO memberDto);
}