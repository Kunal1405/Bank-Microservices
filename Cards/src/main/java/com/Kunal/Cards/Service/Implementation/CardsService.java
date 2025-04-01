package com.Kunal.Cards.Service.Implementation;

import com.Kunal.Cards.Constants.CardConstants;
import com.Kunal.Cards.Dto.CardDto;
import com.Kunal.Cards.Exception.CardAlreadyExistsException;
import com.Kunal.Cards.Exception.CardNotFound;
import com.Kunal.Cards.Mapper.CardMapper;
import com.Kunal.Cards.Model.Cards;
import com.Kunal.Cards.Repositry.CardsRepo;
import com.Kunal.Cards.Service.iCardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsService  implements iCardsService {
    private CardsRepo cardsRepo;

    public void createCard(String mobileNo) {
        Optional<Cards> card=cardsRepo.findByMobileNo(mobileNo);
        if(card.isPresent()){
            throw  new CardAlreadyExistsException("card already exists with given MobileNo.- "+mobileNo);
        }
        cardsRepo.save(createNewCard(mobileNo));
    }

    @Override
    public CardDto fetchCard(String mobileNo) {
      Cards card=cardsRepo.findByMobileNo(mobileNo).orElseThrow(
               ()->  new CardNotFound("No Card Found With Given MobileNo. - "+ mobileNo)
       );
       CardDto cardDto=new CardDto();
        CardMapper.mapToCardDto(card,cardDto);
        return cardDto;
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        String mobileNo=cardDto.getMobileNo();
        Cards card=cardsRepo.findByMobileNo(mobileNo).orElseThrow(
                ()->  new CardNotFound("No Card Found With Given MobileNo. - "+ mobileNo)
        );
        CardMapper.mapToCard(card,cardDto);
        cardsRepo.save(card);
        return true;
    }

    @Override
    public boolean delete(String mobileNo) {
       Cards card=cardsRepo.findByMobileNo(mobileNo).orElseThrow(
               ()->  new CardNotFound("No Card Found With Given MobileNo. - "+ mobileNo)
       );
       cardsRepo.delete(card);
       return true;
    }

    private Cards createNewCard(String mobileNo) {
        Cards newCard=new Cards();
        long randomCardNumber=100000000000L+new Random().nextInt(900000000);
        newCard.setMobileNo(mobileNo);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return newCard;
    }
}
