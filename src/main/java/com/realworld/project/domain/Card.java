package com.realworld.project.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


/**
 * TODO: Like,Image 추가해야합니다.
 */
@Builder
@Getter @Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude
public class Card {
    private Long cardSeq;
    private String title;
    private String content;
    private String category;
    private Long price;
    private int views;
    private LocalDateTime createDt;
    private LocalDateTime regDt;
}
