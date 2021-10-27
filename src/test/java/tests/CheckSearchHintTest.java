package tests;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static testData.TestData.SEARCH_REQUEST;
import static testData.TestData.YANDEX_URL;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@Feature("Test to checks that the hint contains search request")
@Story("A positive scenario")
public class CheckSearchHintTest extends BaseTest {

    @Test
    public void checkSearchHintContainsRequest() {
        basePage
                .goToURL(YANDEX_URL)
                .fillSearchInput(SEARCH_REQUEST);
        basePage.checkRequestInHint();
    }
}
