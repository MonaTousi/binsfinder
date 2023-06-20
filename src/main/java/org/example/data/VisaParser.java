package org.example.data;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class VisaParser implements IParser {
    @Override
    public List<CardEntity> fileParser() {

        List<CardEntity> visaCardList = new ArrayList<CardEntity>();
        try {
            File visaFile = new File("visaFile.txt");
            Scanner visaFileScan = new Scanner(visaFile);

            while (visaFileScan.hasNextLine()) {
                String[] details = visaFileScan.nextLine().split("[|]", 0);
                String rangeStart = details[0];
                String rangeEnd = details[1];
                String type = details[2];
                String active = details[3];
                CardEntity visaCard = new CardEntity(rangeStart, rangeEnd, type, active, CardEntity.Network.VISA_CARD);
                visaCardList.add(visaCard);
            }

            for (CardEntity visaCard : visaCardList) {
                System.out.println(visaCard.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return visaCardList;
    }
}

