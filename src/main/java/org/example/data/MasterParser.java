package org.example.data;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MasterParser implements IParser {
    @Override
    public List<CardEntity> fileParser() {

        List<CardEntity> masterCardList = new ArrayList<CardEntity>();
        try {
            File masterFile = new File("masterFile.txt");
            Scanner masterFileScan = new Scanner(masterFile);

            while (masterFileScan.hasNextLine()) {
                String details = masterFileScan.nextLine();
                String rangeStart = details.substring(0, 16);
                String rangeEnd = details.substring(16, 32);
                String type = details.substring(32, 33);
                String active = details.substring(33);
                CardEntity masterCard = new CardEntity(rangeStart, rangeEnd, type, active, CardEntity.Network.MASTER_CARD);
                masterCardList.add(masterCard);
            }

            for (CardEntity masterCard : masterCardList) {
                System.out.println(masterCard.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return masterCardList;
    }

}
