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
public class CheckResultOnNextPage extends BaseTest {

//    @Test
//    public void goToTheNextResultPage() {
//        basePage.goToURL(YANDEX_URL);
//        basePage.fillSearchInput(SEARCH_REQUEST);
//        basePage.doSearch();
//        resultPage.goToTheNextPageAndCheckResults();
////        resultPage.outputMassive();
//    }
}