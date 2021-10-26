package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static testData.TestData.PROPELLERADS_PROMOTE_URL;
import static testData.TestData.PROPELLERADS_URL;

public class ResultPage extends BasePage {

    private final SelenideElement RESULT_TOTAL = $(By.xpath("//div[@class = 'serp-adv__found']"));
    private final ElementsCollection RESULT_ADS = $$(By.xpath("//li[@class='serp-item desktop-card']/div/div/div/span/" +
            "span[contains(text (), 'Реклама')]"));
    private final ElementsCollection RESULT_SEARCH = $$(By.xpath("//div/div/ul/li/div/h2/a/div/span/b" +
            "[(text ()='PropellerAds') or text()= 'PROPELLERADS']"));
    private final SelenideElement PAGE_VK = $(By.xpath("//li[@class='serp-item desktop-card']/div/h2/a[contains" +
            "(@href, 'vk.com/propellerads')]"));
    private final SelenideElement PAGE_INSTAGRAM = $(By.xpath("//li[@class='serp-item desktop-card']/div/h2/a[contains" +
            "(@href, 'instagram.com/propellerads')]"));
    private final SelenideElement PAGE_FACEBOOK = $(By.xpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'facebook.com')]"));
    private final SelenideElement PAGE_YOUTUBE = $(By.xpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'youtube.com')]"));
    private final SelenideElement PAGE_TWITTER = $(By.xpath("//li[@class='serp-item desktop-card']/div/div/div/a" +
            "[contains(@href, 'twitter.com')]"));
    private final SelenideElement PAGE_PROMOTIONALWEBSITE = $(By.xpath("//li/div/h2/a[not (contains(@href, 'join')) and" +
            "(@rel='noopener')]/div[not(contains(.,'Рекламная сеть ')) and (@class='organic__url-text')]"));
    private final SelenideElement PAGE_WEBSITE = $(By.xpath("//li/div/h2/a[@href='https://propellerads.com/']"));
    private final SelenideElement BUTTON_NEXT = $(By.xpath("//div[@class='pager__items']/a[contains(text (), 'дальше')]"));
    private final SelenideElement BUTTON_CURENT_PAGE = $(By.xpath("//div[@class='pager__items']/" +
            "span[contains(@aria-label, 'Текущая страница')]"));

    public ResultPage checkSocialMediaInSearchResult() {
        RESULT_TOTAL.shouldBe(Condition.visible);
        PAGE_VK.shouldBe(Condition.visible);
        PAGE_INSTAGRAM.shouldBe(Condition.visible);
        PAGE_FACEBOOK.shouldBe(Condition.visible);
        PAGE_YOUTUBE.shouldBe(Condition.visible);
        PAGE_TWITTER.shouldBe(Condition.visible);
        return this;
    }

    public ResultPage checkAdInResultPage() {
        SelenideElement firstAdSerachItem = RESULT_ADS.get(2).shouldBe(Condition.visible);
        List<String> listWithAdResult = RESULT_ADS.texts();
        RESULT_ADS.shouldBe(CollectionCondition.texts(listWithAdResult));
        return this;
    }

    public ResultPage goToTheNextPageAndCheckResults() {
        BUTTON_NEXT.click();
        BUTTON_CURENT_PAGE.isSelected();
        SelenideElement firstSearchItem = RESULT_SEARCH.get(2).shouldBe(Condition.visible);
        List<String> listResults = RESULT_SEARCH.texts();
        RESULT_SEARCH.shouldBe(CollectionCondition.texts(listResults));
        return this;
    }

    public ResultPage goToWebSite() {
        PAGE_WEBSITE.shouldBe(Condition.visible).click();
        switchTo().window(1);
        webdriver().shouldHave(url(PROPELLERADS_URL));
        return this;

    }

    public ResultPage goToPromoteWebSite() {
        PAGE_PROMOTIONALWEBSITE.click();
        switchTo().window(1);
        webdriver().shouldHave(urlContaining(PROPELLERADS_PROMOTE_URL));

        return this;
    }


}
