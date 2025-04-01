package com.Kunal.accounts.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class  Accounts extends BaseEntity {
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Id
    @Column(name = "account_number", unique = true, nullable = false)
    private Long accountNumber;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
