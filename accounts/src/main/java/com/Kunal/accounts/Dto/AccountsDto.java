package com.Kunal.accounts.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
    name = "AccountsDto",description = "Account details of the customer")
public class AccountsDto {

    @Schema(
            description = "Account Type of the customer",
            example = "Savings"
    )
    @NotNull(message = "Account Type is required")
    private String accountType;

    @Schema(
            description = "Account Number of the customer"
    )
    @NotNull(message = "Account Number is required")
    @Pattern(regexp = "^$|[0-9]{10}",message = "Account Number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Branch Address of the customer",
            example = "Pune"
    )
    @NotNull(message = "Branch Address is required")
    private String branchAddress;
}
