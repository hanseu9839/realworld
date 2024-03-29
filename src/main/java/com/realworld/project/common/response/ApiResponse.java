package com.realworld.project.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class ApiResponse<T> {

    private T result; // API 응답 결과 Response

    private int resultCode; // API 응답 코드 Response

    private String resultMsg; // API 응답 코드 Message

    @Builder
    public ApiResponse(final T result, final int resultCode, final String resultMsg){
        this.result = result;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResponseEntity<?> success(final int resultCode,final T result,final String resultMsg){
        return new ResponseEntity<>(ApiResponse.builder()
                .resultCode(200)
                .resultMsg("success")
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<?> success(final T result){
        return new ResponseEntity<>(ApiResponse.builder()
                .result(result)
                .resultCode(200)
                .resultMsg("empty")
                .build(), HttpStatus.OK);
    }

    public static ResponseEntity<?> success(){
        return new ResponseEntity<>(ApiResponse.builder()
                .resultCode(200)
                .resultMsg("empty"), HttpStatus.OK);
    }
}
