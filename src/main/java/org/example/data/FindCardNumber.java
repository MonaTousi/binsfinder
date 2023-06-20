package org.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
@EnableCaching
public class FindCardNumber {
    @Autowired
    public VisaParser visaParser;
    @Autowired
    public MasterParser masterParser;

    private List<CardEntity> cards;


    @PostConstruct
    public void loadData() {
        List<CardEntity> cardV = visaParser.fileParser();
        List<CardEntity> cardM = masterParser.fileParser();
        List<CardEntity> mergeList = new ArrayList<>();
        mergeList.addAll(cardM);
        mergeList.addAll(cardV);
        System.out.println("merge List is: " + mergeList);
        cards = mergeList;
    }

    public List<CardEntity> mergeCards() {
        return cards;
    }

    public CardEntity findCard(int cardNumber) {
        CardEntity cardEntity = new CardEntity();
        Iterator<CardEntity> itrInCardList = mergeCards().iterator();
        while (itrInCardList.hasNext()) {
            CardEntity element = itrInCardList.next();
            int subRngStr = Integer.parseInt(element.getRangeStart().substring(0, 6));
            int subRngEnd = Integer.parseInt(element.getRangeEnd().substring(0, 6));
            if (subRngStr <= cardNumber && cardNumber <= subRngEnd) {
                return cardEntity;
            }
        }
        return null;
    }
}
