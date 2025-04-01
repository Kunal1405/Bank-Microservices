package com.Kunal.Loans.Service.Implementation;

import com.Kunal.Loans.Dto.LoansDto;
import com.Kunal.Loans.Exceptions.LoanAccountAlreadyExists;
import com.Kunal.Loans.Exceptions.NoLoanAccountExist;
import com.Kunal.Loans.Mapper.Mapper;
import com.Kunal.Loans.Model.Loans;
import com.Kunal.Loans.Repositry.LoansRepo;
import com.Kunal.Loans.Service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansService implements ILoansService {

    private LoansRepo repo;
    @Override
    public void applyLoan(String mobileNo) {
        Optional<Loans> loans=repo.findByMobileNo(mobileNo);
        if(loans.isPresent()){
            throw new LoanAccountAlreadyExists("Loan Account already exists with given mobileNo - "+mobileNo);
        }
        Loans loan=createLoan(mobileNo);
        repo.save(loan);
    }

    @Override
    public LoansDto fetchLoan(String mobileNo) {
        Loans loans=repo.findByMobileNo(mobileNo).orElseThrow(
                ()-> new NoLoanAccountExist("No loan Account exists with given mobileNo - "+ mobileNo)
        );
        LoansDto loansDto=new LoansDto();
        Mapper.LoansToLoanDto(loansDto,loans);
        return loansDto;
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans=repo.findByMobileNo(loansDto.getMobileNo()).orElseThrow(
                ()-> new NoLoanAccountExist("No loan account exists with given mobileNo - "+loansDto.getMobileNo())
        );
        Mapper.LoansDtoToLoans(loansDto,loans);
        repo.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNo) {
        Loans loans=repo.findByMobileNo(mobileNo).orElseThrow(
                ()-> new NoLoanAccountExist("No loan account exists with the given mobileNo - "+ mobileNo)
        );
        repo.delete(loans);
        return true;
    }

    private Loans createLoan(String mobileNo){
        Loans loan=new Loans();
        loan.setMobileNo(mobileNo);
        long randomLoanNumber=100000000000L +  new Random().nextInt(900000000);
        loan.setLoanNumber(Long.toString(randomLoanNumber));
        loan.setLoanType("CAR LOAN");
        loan.setLoanAmount(500000);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(500000);

        return loan;
    }
}
