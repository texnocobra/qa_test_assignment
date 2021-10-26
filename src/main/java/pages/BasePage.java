package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private final SelenideElement searchInput = $(byXpath("//input[@id='text']"));
    private final ElementsCollection searchHintItems = $$(byXpath("//ul[@class='mini-suggest__popup-content']/li/b" +
            "[contains(text (), 'propellerads')]"));
    private final SelenideElement searchButton = $(byXpath("//button[@type='submit']"));

    public void goToURL(String url) {
        open(url);
    }

    public void doSearch() {
        searchButton.click();
    }

    public void fillSearchInput(String testrequest) {
        searchInput.val(testrequest);
    }

    public void checkRequestInHint() {
        searchHintItems.first().shouldBe(visible);
        List<String> listHints = searchHintItems.texts();
        searchHintItems.shouldBe(CollectionCondition.texts(listHints));
    }
}
