package com.dtn.app;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.dao.AssetsDao;
import com.dtn.app.service.LightningService;

import java.util.Scanner;

import static com.dtn.app.constants.AppConstants.*;

public class LightningApp {
    private boolean stayInMenu;
    private String userInput;
    private Scanner input;
    private AssetsDao assetsDao;

    public LightningApp() {
        stayInMenu = true;
        input = new Scanner(System.in);
        assetsDao = new AssetsDao("/assets.json");

    }

    public static void main( String[] args ) {
        LightningApp lightningApp = new LightningApp();

        System.out.print(APP_NAME);
        while (lightningApp.stayInMenu) {
            lightningApp.showMenu(AppConstants.MENU);
            if (lightningApp.userInput.equalsIgnoreCase(MENU_EXIT)) {
                lightningApp.stayInMenu = false;
            } else if (lightningApp.userInput.equalsIgnoreCase(MENU_PROCEED)) {
                LightningService lightningService = new LightningService(lightningApp.assetsDao);
                lightningService.handleLightningData();
                lightningApp.stayInMenu = true;
            } else {
                System.out.println(AppConstants.MENU_SELECT_CHOICE);
            }
        }
    }

    private void showMenu (String display) {
        System.out.print(display);
        this.userInput = (this.input.nextLine()).trim();
        if (this.userInput.length() == 0) {
            this.userInput = AppConstants.BLANKINPUT;
        }
    }
}
