package com.Kunal.Cards.Mapper;

import com.Kunal.Cards.Dto.CardDto;
import com.Kunal.Cards.Model.Cards;

public class CardMapper {
    public  static void mapToCardDto(Cards card,CardDto cardDto){
        cardDto.setMobileNo(card.getMobileNo());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setAvailableAmount(card.getAvailableAmount());

    }
    public static void mapToCard(Cards card , CardDto cardDto){
        card.setMobileNo(cardDto.getMobileNo());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
    }
}
