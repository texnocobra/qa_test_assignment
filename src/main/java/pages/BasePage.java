package pages;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public void goToURL(String URL) {
        open(URL);
    }
}
