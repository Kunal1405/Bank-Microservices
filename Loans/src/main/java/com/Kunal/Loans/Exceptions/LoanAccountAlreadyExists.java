package com.Kunal.Loans.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanAccountAlreadyExists extends RuntimeException{
    public LoanAccountAlreadyExists(String message){
        super(message);
    }
}
