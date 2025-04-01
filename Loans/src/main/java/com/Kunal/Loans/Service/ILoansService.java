package com.Kunal.Loans.Service;

import com.Kunal.Loans.Dto.LoansDto;

public interface ILoansService {
    void applyLoan(String mobileNo);

    LoansDto fetchLoan(String mobileNo);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNo);
}
