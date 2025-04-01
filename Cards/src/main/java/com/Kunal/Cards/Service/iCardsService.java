package com.Kunal.Cards.Service;

import com.Kunal.Cards.Dto.CardDto;
import com.Kunal.Cards.Model.Cards;

public interface iCardsService {
    void createCard(String mobileNo);

    CardDto fetchCard(String mobileNo);

    boolean updateCard(CardDto cardDto);

    boolean delete(String mobileNo);
}
