package com.dtn.app;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.dao.AssetsDao;
import com.dtn.app.service.LightningService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
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

        System.out.print("\nLightning App Program\n");
        while (lightningApp.stayInMenu) {
            lightningApp.showMenu(AppConstants.MENU);
            if (lightningApp.userInput.equalsIgnoreCase("x")) {
                lightningApp.stayInMenu = false;
            } else if (lightningApp.userInput.equalsIgnoreCase("x")) {
                LightningService lightningService = new LightningService();
                lightningService.handleLightningData(lightningApp.userInput, lightningApp.assetsDao);
                lightningApp.stayInMenu = true;
            } else {
                System.out.println(AppConstants.MENU_SELECT_CHOICE);
            }
        }
    }

    public void showMenu (String display) {
        System.out.print(display);
        this.userInput = (this.input.nextLine()).trim();
        if (this.userInput.length() == 0) {
            this.userInput = AppConstants.BLANKINPUT;
        }
    }
}
