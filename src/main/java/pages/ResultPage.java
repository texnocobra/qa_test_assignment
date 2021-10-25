package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage extends BasePage{

    private final SelenideElement RESULT_TOTAL = $(By.xpath("//div[@class = 'serp-adv__found']"));
    private final ElementsCollection RESULT_ADS = $$(By.xpath("//li[@class='serp-item desktop-card']/div/div/div/span/span[contains(text (), 'Реклама')]"));
    private final ElementsCollection RESULT_SEARCH = $$(By.xpath("//div/div/ul/li"));
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
    private final SelenideElement BUTTON_NEXT = $(By.xpath("//div[@class='pager__items']/a[contains(text (), 'дальше')]"));
    private final SelenideElement BUTTON_CURENT_PAGE = $(By.xpath("//div[@class='pager__items']/span[contains(@aria-label, 'Текущая страница')]"));

    public ResultPage checkSocialMediaInSearchResult(){
        RESULT_TOTAL.shouldBe(Condition.visible);
        PAGE_VK.shouldBe(Condition.visible);
        PAGE_INSTAGRAM.shouldBe(Condition.visible);
        PAGE_FACEBOOK.shouldBe(Condition.visible);
        PAGE_YOUTUBE.shouldBe(Condition.visible);
        PAGE_TWITTER.shouldBe(Condition.visible);
        return this;
    }

    public  ResultPage checkAdInResultPage() {
        SelenideElement firstAdSerachItem = RESULT_ADS.get(2).shouldBe(Condition.visible);
        List<String> listWithAdResult = RESULT_ADS.texts();
        RESULT_ADS.shouldBe(CollectionCondition.texts(listWithAdResult));
        return this;
    }

//    public ResultPage goToTheNextPageAndCheckResults() {
//        BUTTON_NEXT.click();
//        BUTTON_CURENT_PAGE.isSelected();
//        SelenideElement firstSearchItem = RESULT_SEARCH.get(2).shouldBe(Condition.visible);
//        List<String> listResults = RESULT_SEARCH.texts();
//        RESULT_SEARCH.shouldBe(CollectionCondition.texts(listResults));
//        return this;
//    }

//    public ResultPage outputMassive() {
//        List<String> listResults = RESULT_SEARCH.texts();
//        System.out.println();
//        return this;
//    }
}
