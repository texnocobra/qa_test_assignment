package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static testData.TestData.PROPELLERADS_PROMOTE_URL;
import static testData.TestData.PROPELLERADS_URL;

public class ResultPage extends BasePage {

    private final SelenideElement resultTotal = $(byXpath("//div[@class = 'serp-adv__found']"));
    private final ElementsCollection resultAds = $$(byXpath("//li[@class='serp-item desktop-card']/div/div/div/span/" +
            "span[contains(text (), 'Реклама')]"));
    private final ElementsCollection resultSearch = $$(byXpath("//div/div/ul/li/div/h2/a/div/span/b" +
            "[(text ()='PropellerAds') or text()= 'PROPELLERADS']"));
    private final SelenideElement pageVk = $(byXpath("//li[@class='serp-item desktop-card']/div/h2/a[contains" +
            "(@href, 'vk.com/propellerads')]"));
    private final SelenideElement pageInstagram = $(byXpath("//li[@class='serp-item desktop-card']/div/h2/a[contains" +
            "(@href, 'instagram.com/propellerads')]"));
    private final SelenideElement pageFaceboook = $(byXpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'facebook.com')]"));
    private final SelenideElement pageYoutube = $(byXpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'youtube.com')]"));
    private final SelenideElement pageTwitter = $(byXpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'twitter.com')]"));
    private final SelenideElement pagePromotionalWebSite = $(byXpath("//li/div/div/div/a/b[contains(text (), " +
            "'joinpropeller.com')]"));
    private final SelenideElement pageWebSite = $(byXpath("//li/div/h2/a[@href='https://propellerads.com/']"));
    private final SelenideElement buttonNext = $(byXpath("//div[@class='pager__items']/a[contains" +
            "(text (), 'дальше')]"));
    private final SelenideElement buttonCurrentPage = $(byXpath("//div[@class='pager__items']/" +
            "span[contains(@aria-label, 'Текущая страница')]"));

    public ResultPage checkSocialMediaInSearchResult() {
        resultTotal.shouldBe(visible);
        pageVk.shouldBe(visible);
        pageInstagram.shouldBe(visible);
        pageFaceboook.shouldBe(visible);
        pageYoutube.shouldBe(visible);
        pageTwitter.shouldBe(visible);

        return this;
    }

    public ResultPage checkAdInResultPage() {
        resultAds.get(2).shouldBe(visible);
        List<String> listWithAdResult = resultAds.texts();
        resultAds.shouldBe(CollectionCondition.texts(listWithAdResult));

        return this;
    }

    public ResultPage goToTheNextPageAndCheckResults() {
        buttonNext.click();
        buttonCurrentPage.isSelected();
        resultSearch.get(2).shouldBe(visible);
        List<String> listResults = resultSearch.texts();
        resultSearch.shouldBe(CollectionCondition.texts(listResults));

        return this;
    }

    public ResultPage goToWebSite() {
        pageWebSite.shouldBe(visible).click();
        switchTo().window(1);
        webdriver().shouldHave(url(PROPELLERADS_URL));

        return this;

    }

    public ResultPage goToPromoteWebSite() {
        pagePromotionalWebSite.click();
        switchTo().window(1);
        webdriver().shouldHave(urlContaining(PROPELLERADS_PROMOTE_URL));

        return this;
    }
}
