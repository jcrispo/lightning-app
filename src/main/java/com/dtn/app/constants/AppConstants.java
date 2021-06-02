package com.dtn.app.constants;

public class AppConstants {

    private AppConstants() {
    }

    public static final String APP_NAME = "\nLightning Alert App\n";
    public static final String MENU = "\nInput lightning data (a), Exit (x): ";
    public static final String MENU_EXIT = "x";
    public static final String MENU_PROCEED = "a";
    public static final String EXIT_USER_INPUT = "d";
    public static final String MENU_SELECT_CHOICE = "\nPlease select from the given choices. ";
    public static final String MENU_INPUT_DATA_CHOICE = "\n\"Enter lightning strike data. Type 'd' when done.\"";
    public static final String BLANKINPUT = "b";
    public static final String INVALID_LIGHTNING_DATA = "\nThe provided lightning data format is invalid for user input: ";
    public static final String LIGHTNING_ALERT = "\nLightning alert for %s:%s";
    public static final String LIGHTNING_NO_HIT = "\nLightning did not hit any asset.";
    public static final String LIGHTNING_DATA_SKIPPED = "\nData will be skipped.";
    public static final int ZOOM_LEVEL = 12;
    public static final int FLASHTYPE_GROUND = 0;
    public static final int FLASHTYPE_CLOUD = 1;
    public static final int FLASHTYPE_HEARTBEAT = 9;
}
