package org.example.service;

import org.example.data.CardEntity;
import org.example.data.FindCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinFinderService {
    @Autowired
    public BinFinderService(FindCardNumber findCardNumber) {
        this.findCardNumber = findCardNumber;
    }

    FindCardNumber findCardNumber;

    public CardEntity findCard(int cardNumber) {
       CardEntity finalResultCard = findCardNumber.findCard(cardNumber);
        return finalResultCard;
    }
}
