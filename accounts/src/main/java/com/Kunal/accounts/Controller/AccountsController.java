package com.Kunal.accounts.Controller;

import com.Kunal.accounts.Dto.ErrorResponseDto;
import com.Kunal.accounts.Service.IAccountService;
import com.Kunal.accounts.Dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
@Tag(
        name = "Account Controller",
        description = "APIs for Account Management"
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsController {
    private  IAccountService iaccountService;

    @Operation(summary = "Create an account",
            description = "This API is used to create an account")
    @ApiResponse(
            responseCode = "201",
            description = "Account created successfully"
    )
    @ApiResponse(
            responseCode = "409",
            description = "Customer already exists with given mobile no.",
            content=@Content(
                    schema=@Schema(
                            implementation = ErrorResponseDto.class
                    )
            )
    )
    @PostMapping("create")
    public ResponseEntity<String> createAccount(@RequestBody @Valid CustomerDto customerDto) {
        iaccountService.createAccount(customerDto);
        return  new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);

    }
    @Operation(
            summary = "Fetch an account",
            description = "This API is used to fetch an account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Account fetched successfully"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Account not found"
    )
    @GetMapping("fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam
                                                        @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must be 10 digits")
                                                        String mobileNo) {
        CustomerDto customerDto = iaccountService.fetchAccount(mobileNo);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Update an account",
            description = "This API is used to update an account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Account updated successfully"
    )
    @ApiResponse(
            responseCode = "409",
            description = "Account number is not matching with any existing account"
     )

    @PutMapping("update")
    public ResponseEntity<String> updateDetails(@RequestBody @Valid CustomerDto customerDto){
        Boolean isUpdated=iaccountService.updateDetails(customerDto);
        if(isUpdated){
            return new ResponseEntity<>("Details Updated, Confirm by fetching details !",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Account number is not matching with any existing account",HttpStatus.CONFLICT);
    }

    @Operation(
        summary = "Delete an account",
            description = "This API is used to delete an account"
    )
    @ApiResponse(
            responseCode = "202",
            description = "Account Deleted ! Want to Create a New One ??"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Error Occured , Insert Valid mobileNo"
    )
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteAccount(@RequestParam
                                                    @Pattern(regexp = "^$ |[0-9]{10}",message = "Mobile Number must be 10 digits")
                                                    String mobileNo){
        Boolean isDeleted=iaccountService.deleteAccount(mobileNo);
        if(isDeleted){
            return  new ResponseEntity<>("Account Deleted ! Want to Create a New One ??",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Error Occured , Insert Valid mobileNo",HttpStatus.NOT_ACCEPTABLE);
    }
}
 