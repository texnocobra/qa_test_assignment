package common;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static common.Config.CLEAR_COOKIES;

public class CommonAction {
    public static final Logger LOGGER = LoggerFactory.getLogger(CommonAction.class);


    /**
     * Метод для работы с Куками
     */
    public static void clearBrowserCookieAndStorage() {
        if (CLEAR_COOKIES) {
            try {
                Selenide.clearBrowserCookies();
                Selenide.clearBrowserLocalStorage();

                Selenide.executeJavaScript("window.sessionStorage.clear");
            } catch (Exception e) {
                LOGGER.error(String.format("Fail to clearBrowserCookieAndStorage() - %s", e.getMessage()));
            }
        }
    }
}