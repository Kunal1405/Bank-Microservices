package com.Kunal.Loans.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int loanId;

    private  String mobileNo;

    private String  loanNumber;

    private String loanType;

    private int loanAmount;

    private int amountPaid;

    private int outstandingAmount;
}
