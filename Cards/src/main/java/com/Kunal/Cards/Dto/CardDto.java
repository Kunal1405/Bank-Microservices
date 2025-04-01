package com.Kunal.Cards.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Card",
        description = "Schema to hold card details"
)
public class CardDto {

    @Schema(
            name = "Mobile Number",
            example = "9410053125"
    )

    @NotNull(message = "Mobile number cannot be null!")
    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile number must be of 10 digits!")
    private String mobileNo;

    @Schema(
            name = "Account Number",
            example = "192345238942"
    )
    @NotNull(message = "Account number cannot be null!")
    @Pattern(regexp = "^$|[0-9]{12}",message = "Account number must contains 12 digits!")
    private String cardNumber;

    @Schema(
            name = "Card Type",
            example = "Credit Card"
    )
    @NotNull(message = "Card type cannot be null!")
    private String cardType;

    @Schema(
            name="Total Limit",
            example="100000"
    )
    @Positive(message = "Total card limit must be greater than 0!")
    private int totalLimit;

    @Schema(
            name = "Amount Used",
            example = "50000"
    )
    @PositiveOrZero(message = "Amount used must be greater than or equal to 0!")
    private int amountUsed;

    @Schema(
            name = "Available Amount",
            example = "50000"
    )
    @PositiveOrZero(message = "Available Amount  must be greater than or equal to 0!")
    private int availableAmount;
}
