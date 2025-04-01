package com.Kunal.Loans.Repositry;

import com.Kunal.Loans.Model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepo extends JpaRepository<Loans,Integer> {

    Optional<Loans> findByMobileNo(String mobileNo);
}
