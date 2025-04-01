package com.Kunal.accounts.Service;

import com.Kunal.accounts.Dto.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNo);

    Boolean updateDetails(CustomerDto customerDto);

    Boolean deleteAccount(String mobileNo);
}
