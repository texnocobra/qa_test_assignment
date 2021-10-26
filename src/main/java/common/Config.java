package common;

import com.codeborne.selenide.Configuration;

public class Config {
    public static final String BROWSER_NAME = "chrome"; //chrome firefox edge ie opera
    public static final Boolean CLEAR_COOKIES = true;
    public static final Boolean HOLD_BROWSER_OPEN = false;
    public static final Boolean CLEAR_REPORTS_DIR = true;
    public static final Boolean START_FULL_SCREEN = true;


    static {
        Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER_NAME;
        Configuration.startMaximized = START_FULL_SCREEN;
    }
}