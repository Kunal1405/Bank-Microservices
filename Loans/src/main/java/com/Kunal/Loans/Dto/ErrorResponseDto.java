package com.Kunal.Loans.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold Error response information"
)
public class ErrorResponseDto {

    @Schema(
            name = "Api Path",
            example = "https://localhost:8080/loans/apply"
    )
    private  String apiPath;

    @Schema(
            name = "Error Code",
            example = "404"
    )
    private HttpStatus errorCode;

    @Schema(
            name = "Error Mesage",
            example = "Loan Account already exists"
    )
    private String errorMsg;

    @Schema(
            name = "Error Time",
            example = "2025-04-01T12:30:45"
    )
    private LocalDateTime errorTime;
}
