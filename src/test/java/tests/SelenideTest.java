package tests;

import com.codeborne.selenide.Condition;
import common.Listener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;



@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class SelenideTest extends BaseTest {

    @Test
    public void test(){
        open("https://google.com/");
        $x("//input[@name = 'qs']").setValue("ChromeDriver").pressEnter();
        $x("//div[@id = 'result-stats']").shouldBe(Condition.visible);

    }
}
