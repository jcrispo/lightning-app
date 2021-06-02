package com.dtn.app.service;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.model.LightningStrike;
import com.dtn.app.utility.JsonUtility;

import java.util.Map;
import java.util.Scanner;

public class UserInputService {
    private Scanner dataIn;
    private boolean dataIsValid;

    public UserInputService() {
        dataIn = new Scanner(System.in);
        dataIsValid = false;
    }

    public LightningStrike getValidLightningData(String print) {
        LightningStrike lightningStrike = null;
        while (!dataIsValid) {
            System.out.print(print);
            String tempString = dataIn.nextLine().trim();
            try {
                Map<String, Object> lightningDataMap = JsonUtility.fromJsonToMap(tempString);
                lightningStrike = new LightningStrike(lightningDataMap);
                dataIsValid = true;
            } catch(Exception e) {
                System.out.println(AppConstants.INVALID_LIGHTNING_DATA);
                dataIsValid = false;
            }
        }
        dataIsValid = false;

        return lightningStrike;
    }
}
