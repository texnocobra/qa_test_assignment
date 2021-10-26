package tests;

import common.Listener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static testData.TestData.SEARCH_REQUEST;
import static testData.TestData.YANDEX_URL;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class CheckSearchHintTest extends BaseTest {

    @Test
    public void checkSearchHintContainsRequest() {
        basePage
                .goToURL(YANDEX_URL)
                .fillSearchInput(SEARCH_REQUEST);
        basePage.checkRequestInHint();
    }
}
