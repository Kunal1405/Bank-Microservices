package com.Kunal.Cards.Repositry;

import com.Kunal.Cards.Model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepo extends JpaRepository<Cards,Integer> {

    Optional<Cards> findByMobileNo(String mobileNo);
}
