package com.realworld.feature.member.entity;

import com.realworld.feature.auth.Authority;
import com.realworld.feature.file.entity.FileJpaEntity;
import com.realworld.feature.like.entity.LikeJpaEntity;
import com.realworld.feature.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
@Builder
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))
public class MemberJpaEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    private String password;

    private String phoneNumber;

    private String userEmail;

    private String delYn;

    private String nickname;

    @OneToOne
    @JoinColumn(name = "file_id")
    private FileJpaEntity file;

    @LastModifiedDate
    private LocalDateTime regDt;

    @CreatedDate
    private LocalDateTime createDt;

    @Enumerated(EnumType.STRING)
    private Authority authority;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeJpaEntity> likes;

    public Member toDomain() {
        return Member.builder()
                .password(getPassword())
                .userId(getUserId())
                .userEmail(getUserEmail())
                .phoneNumber(getPhoneNumber())
                .file(getFile().toDomain())
                .nickname(getNickname())
                .createDt(getCreateDt())
                .regDt(getRegDt())
                .delYn(getDelYn())
                .authority(getAuthority())
                .build();
    }

    public Member productToDomain() {
        return Member.builder()
                .userId(this.userId)
                .userEmail(this.userEmail)
                .nickname(this.nickname)
                .build();
    }
}
