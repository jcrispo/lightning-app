package com.dtn.app.service;

import com.dtn.app.model.LightningStrike;
import com.dtn.app.utility.JsonUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.dtn.app.constants.AppConstants.INVALID_LIGHTNING_DATA;
import static com.dtn.app.constants.AppConstants.LIGHTNING_DATA_SKIPPED;

public class UserInputService {
    private Scanner dataIn;

    public UserInputService() {
        dataIn = new Scanner(System.in);
    }

    public List<LightningStrike> getValidLightningData(String print) {
        List<LightningStrike> lightningStrikeList = new ArrayList<>();

        System.out.println(print);
        while (dataIn.hasNext()) {
            String userInput = dataIn.nextLine().trim();
            if ("d".equalsIgnoreCase(userInput)) break;

            try {
                Map<String, Object> lightningDataMap = JsonUtility.fromJsonToMap(userInput);

                if (lightningDataMap == null || lightningDataMap.isEmpty()) throw new IllegalArgumentException(INVALID_LIGHTNING_DATA);

                LightningStrike lightningStrike = new LightningStrike(lightningDataMap);
                lightningStrikeList.add(lightningStrike);
            } catch(Exception e) {
                System.out.println(INVALID_LIGHTNING_DATA + "for user input: " + userInput);
                System.out.println(LIGHTNING_DATA_SKIPPED);
            }
        }

        return lightningStrikeList;
    }
}
