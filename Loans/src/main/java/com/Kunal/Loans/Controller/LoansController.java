package com.Kunal.Loans.Controller;

import com.Kunal.Loans.Dto.ErrorResponseDto;
import com.Kunal.Loans.Dto.LoansDto;
import com.Kunal.Loans.Service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@AllArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@Validated
@RequestMapping("/loans")
@Tag(
        name="Crud rest api for Loans",
        description = "Crud rest api for Loans to create,update,delete and fetch loan details"

)
public class LoansController {
    private ILoansService loansService;


    @Operation(
            summary = "Create Loan Account",
            description = "create a new loan account with given mobile number"
    )
    @ApiResponses(
            { @ApiResponse(
                    responseCode ="201",
                    description = "HttpStatus.CREATED"
            ),
            @ApiResponse(
                responseCode = "400",
                description = "HttpStatus.BAD_REQUEST",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class
                            )
                    )
            )
            }
    )
    @PostMapping("/apply")
    public ResponseEntity<String> applyLoan(@RequestParam @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must contains 10 digits!") String mobileNo){
        loansService.applyLoan(mobileNo);
        return new ResponseEntity<>("Loan Account successfully Created", HttpStatus.CREATED );
    }


    @Operation(
            summary = "Fetch Loan Account Details",
            description = "Fetch Loan account details for given mobile number."
    )
    @ApiResponses(
            {
            @ApiResponse(
                    responseCode = "202",
                    description = "HttpStatus.ACCEPTED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HttpStatus.BAD_REQUEST",
    content = @Content(
            schema = @Schema(
                    implementation = ErrorResponseDto.class
            )
    )
            )
    }
    )
    @GetMapping("/fetchLoan/{mobileNo}")
    public ResponseEntity<LoansDto> fetchLoan(@PathVariable @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must contains 10 digits!") String mobileNo){
        LoansDto loansDto=loansService.fetchLoan(mobileNo);
        return new ResponseEntity<>(loansDto,HttpStatus.ACCEPTED);
    }


    @Operation(
            summary = "Update Loan Account Details",
            description = "Update Loan account details by giving the details."
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "202",
                            description = "HttpStatus.ACCEPTED"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "HttpStatus.BAD_REQUEST",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )
                    )
            }
    )
    @PostMapping("/update")
    public ResponseEntity<String> updateLoan( @Valid @RequestBody LoansDto loansDto){
        boolean isUpdated=loansService.updateLoan(loansDto);
        if(isUpdated){
            return  new ResponseEntity<>("Loan Account Successfully Updated",HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>("Error Updating Loan Account",HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Delete Loan Account",
            description = "Delete Loan account for given mobile number."
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "202",
                            description = "HttpStatus.ACCEPTED"
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "HttpStatus.NOT_ACCEPTABLE",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("/deleteAccount/{mobileNo}")
    public  ResponseEntity<String> deleteLoan(@PathVariable @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must contains 10 digits!") String mobileNo){
        boolean isDeleted=loansService.deleteLoan(mobileNo);
        if(isDeleted){
            return  new ResponseEntity<>("Account Deleted!",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Error Occured , Please Try Again!",HttpStatus.NOT_ACCEPTABLE);
    }
}
