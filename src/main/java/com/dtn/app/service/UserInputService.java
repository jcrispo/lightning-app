package com.dtn.app.service;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.model.LightningStrike;
import com.dtn.app.utility.JsonUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInputService {
    private static Scanner dataIn;
    private static boolean dataIsValid;
    private static String tempString;

    public UserInputService() {
        dataIn = new Scanner(System.in);
        dataIsValid = false;
    }

    public LightningStrike getValidLightningData(String print) {
        LightningStrike lightningStrike = null;
        Map<String, Object> lightningDataMap = new HashMap<>();
        while (!dataIsValid) {
            System.out.print(print);
            tempString = dataIn.nextLine().trim();
            try {
                lightningDataMap = JsonUtility.fromJsonToMap(tempString);
                lightningStrike = new LightningStrike(lightningDataMap);
                dataIsValid = true;
            } catch(Exception e) {
                System.out.println(AppConstants.INVALID_LIGHTNING_DATA);
                e.printStackTrace();
                dataIsValid = false;
            }
        }
        dataIsValid = false;

        return lightningStrike;
    }
}
