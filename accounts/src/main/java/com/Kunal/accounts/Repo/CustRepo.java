package com.Kunal.accounts.Repo;

import com.Kunal.accounts.Model.Accounts;
import com.Kunal.accounts.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustRepo extends JpaRepository<Customers,Long> {
    Optional<Customers> findBymobileNo(String mobileNo);

}
