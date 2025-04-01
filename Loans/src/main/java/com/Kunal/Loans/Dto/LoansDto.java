package com.Kunal.Loans.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Loan",
        description = "Schema to hold loan details"
)
public class LoansDto {

    @Schema(
            name = "Mobile Number",
            description = "Mobile number must be of 10 digits",
            example = "9874153456"
    )
    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must contains 10 digits!")
    @NotNull(message = "Mobile Number Cannot Be Null")
    private  String mobileNo;

    @Schema(
            name = "Loan Number",
            example = "123456789012"
    )
    @Pattern(regexp = "^$|[0-9]{12}",message = "Mobile Number must contains 10 digits!")
    @NotNull(message = "Account Number Cannot Be Null")
    private String loanNumber;

    @Schema(
            name = "Loan Type",
            example = "Home Loan"
    )
    @NotNull(message = "Loan Type Cannot Be Null")
    private String loanType;

    @Schema(
            name = "Loan Amount",
            example = "500000"
    )
    @Positive(message = "Loan Amount Should Be Greater Than 0 !")
    private int loanAmount;

    @Schema(
            name = "Amount Paid",
            example = "250000"
    )
    @PositiveOrZero(message = "Amount Paid Should Be Greater Or Equal To Zero")
    private int amountPaid;

    @Schema(
            name = "Outsanding Amount",
            example = "250000"
    )
    @PositiveOrZero(message = "Outstanding Amount Should Be Greater Or Equal To Zero")
    private int outstandingAmount;
}
