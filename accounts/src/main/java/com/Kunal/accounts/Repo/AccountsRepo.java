package com.Kunal.accounts.Repo;

import com.Kunal.accounts.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByCustomerId(Long customerId);
}
