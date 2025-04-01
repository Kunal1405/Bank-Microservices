package com.Kunal.accounts.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
    description = "Response Dto",
    example = "{\"statusCode\":\"200\",\"msg\":\"Success\"}"
)
public class ResponseDto {
    @Schema(
            description = "Status Code",
            example = "200"
    )
    private  String statusCode;
    @Schema(
            description = "Message",
            example = "Success"
    )
    private  String msg;
}
