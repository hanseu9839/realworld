package com.realworld.project.application.port.in.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {
    @JsonProperty("card_seq")
    private Long cardSeq;
    private String title;
    private String content;
    private Long price;
    private String category;
    private int views;
    @JsonProperty("create_dt")
    private LocalDateTime createDt;
    private LocalDateTime regDt;
}
