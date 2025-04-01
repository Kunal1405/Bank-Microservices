package com.Kunal.accounts.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
    name = "Customer",
    description = "Schema to hold customer and account details"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Kunal"
    )
    @NotNull(message = "Name is required")
    @Size(min=3,max=20,message = "Name must be between 3 and 20 characters")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "9gMqZ@example.com"
    )
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @Schema(
            description = "Mobile No of the customer",
            example = "1234567890"
    )
    @NotNull(message = "Mobile No is required")
    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must be 10 digits")
    private String mobileNo;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;
}
