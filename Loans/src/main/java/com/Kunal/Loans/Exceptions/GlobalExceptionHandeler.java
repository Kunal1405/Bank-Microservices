package com.Kunal.Loans.Exceptions;

import com.Kunal.Loans.Dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandeler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LoanAccountAlreadyExists.class)
    public ResponseEntity<ErrorResponseDto> handleLoanAccountAlreadyExistsException(LoanAccountAlreadyExists loanAccountAlreadyExists, WebRequest webRequest){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                loanAccountAlreadyExists.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoLoanAccountExist.class)

    public ResponseEntity<ErrorResponseDto> handleNoLoanAccountExist(NoLoanAccountExist noLoanAccountExist, WebRequest webRequest){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                noLoanAccountExist.getMessage(),
                LocalDateTime.now()
        );
        return  new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }
}
