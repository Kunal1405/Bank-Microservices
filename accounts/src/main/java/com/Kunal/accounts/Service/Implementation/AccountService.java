package com.Kunal.accounts.Service.Implementation;

import com.Kunal.accounts.Dto.AccountsDto;
import com.Kunal.accounts.Exception.ResourceNotFound;
import com.Kunal.accounts.Mapper.AccountMapper;
import com.Kunal.accounts.Service.IAccountService;
import com.Kunal.accounts.Dto.CustomerDto;
import com.Kunal.accounts.Exception.CustomerAlreadyExists;
import com.Kunal.accounts.Mapper.CustomerMapper;
import com.Kunal.accounts.Model.Accounts;
import com.Kunal.accounts.Model.Customers;
import com.Kunal.accounts.Repo.AccountsRepo;
import com.Kunal.accounts.Repo.CustRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {
    private AccountsRepo accountsRepo;

    private CustRepo custRepo;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customers customers= CustomerMapper.mapToCustomers(customerDto,new Customers());
        Optional<Customers> cust=custRepo.findBymobileNo(customers.getMobileNo());
        if(cust.isPresent()){
            throw new CustomerAlreadyExists("Customer already exists with given mobile no. "+ customers.getMobileNo());
        }
        custRepo.save(customers);
        Accounts account=createAccount(customers);
        accountsRepo.save(account);
    }

    @Override
    public CustomerDto fetchAccount(String mobileNo) {
      Customers customers=custRepo.findBymobileNo(mobileNo).orElseThrow(()-> new ResourceNotFound("Customer","Mobile Number",mobileNo));
      Accounts account=accountsRepo.findByCustomerId(customers.getCustomer_id()).orElseThrow(()-> new ResourceNotFound("Account","CustomerId",customers.getCustomer_id().toString()));
      CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customers,new CustomerDto());
      customerDto.setAccountsDto(AccountMapper.mapToAccountsDto(account,new AccountsDto()));
      return customerDto;

    }

    @Override
    public Boolean updateDetails(CustomerDto customerDto) {
        Boolean isUpdated=false;
        AccountsDto accountsDto=customerDto.getAccountsDto();
        if(accountsDto!=null){
            Accounts accounts=accountsRepo.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()-> new ResourceNotFound("Account " ,"AccountNumber",accountsDto.getAccountNumber().toString()
                    )
            );
            AccountMapper.mapToAccounts(accountsDto,accounts);
            accountsRepo.save(accounts);
            Long customerId=accounts.getCustomerId();
            Customers customers=custRepo.findById(customerId).orElseThrow(
                    ()->new ResourceNotFound("Customer","CustomerId",customerId.toString()
                    )
            );
            CustomerMapper.mapToCustomers(customerDto,customers);
            custRepo.save(customers);
            isUpdated=true;
        }
        return isUpdated;
    }
    @Override
    public Boolean deleteAccount(String mobileNo) {
       Boolean isDeleted=false;
       Customers customer=(custRepo.findBymobileNo(mobileNo)).orElseThrow(()->
               new ResourceNotFound("Customer","MobileNumber",mobileNo));
       Long customerId=customer.getCustomer_id();
       custRepo.deleteById(customerId);
       Accounts account=accountsRepo.findByCustomerId(customerId).orElseThrow(()->
               new ResourceNotFound("Account","customer id",customerId.toString()));
       accountsRepo.deleteById(account.getAccountNumber());
       isDeleted=true;

       return isDeleted;
    }

    public Accounts createAccount(Customers customers) {
        Accounts account=new Accounts();
        account.setCustomerId(customers.getCustomer_id());
        account.setAccountType("savings");
        long accountNumber = 1000000000L+ new Random().nextInt(900000000);
        account.setAccountNumber(accountNumber);
        account.setBranchAddress("kolkata");
        return account;
    }
}
