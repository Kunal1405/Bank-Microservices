package com.Kunal.Loans.Mapper;

import com.Kunal.Loans.Dto.LoansDto;
import com.Kunal.Loans.Model.Loans;

public class Mapper {
    public static void LoansToLoanDto(LoansDto loansDto, Loans loans){
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setMobileNo(loans.getMobileNo());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setLoanAmount(loans.getLoanAmount());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
    }

    public static void LoansDtoToLoans(LoansDto loansDto, Loans loans){
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setMobileNo(loansDto.getMobileNo());
        loans.setLoanType(loansDto.getLoanType());
        loans.setLoanAmount(loansDto.getLoanAmount());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
    }

}

