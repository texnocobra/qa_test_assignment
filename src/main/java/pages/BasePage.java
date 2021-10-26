package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private final SelenideElement SEARCH_INPUT = $(By.xpath("//input[@id='text']"));
    private final ElementsCollection SEARCH_HINT_ITEMS = $$(By.xpath("//ul[@class='mini-suggest__popup-content']/li/b" +
            "[contains(text (), 'propellerads')]"));
    private final SelenideElement SEARCH_BUTTON = $(By.xpath("//button[@type='submit']"));

    public void goToURL(String url) {
        open(url);
    }

    public void doSearch() {
        SEARCH_BUTTON.click();
    }

    public void fillSearchInput(String testrequest) {
        SEARCH_INPUT.val(testrequest);
    }

    public void checkRequestInHint() {
        SelenideElement firstSerachHintItem = SEARCH_HINT_ITEMS.first().shouldBe(Condition.visible);
        List<String> listHints = SEARCH_HINT_ITEMS.texts();
        SEARCH_HINT_ITEMS.shouldBe(CollectionCondition.texts(listHints));
    }

}
