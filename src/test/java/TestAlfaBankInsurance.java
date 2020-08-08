import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAlfaBankInsurance {

    @BeforeEach
    public void setUp() {
        open("https://alfabank.ru/make-money/savings-account/");
        //переходим по Депозитам
    }

    @Test
    public void workInsuranceSibling() {

        $(".navigation").$(byText("Депозиты")).click();
        //проверяем переключилась ли страница и появилось ли окно Депозиты
        $(".selected").shouldBe(text("Депозиты")).sibling(3).click();
        $(".frame-head").shouldBe(text("Страхование вкладов"));
    }

    @Test
    public void workInsurancePreceding() {

        $(".product-cell").preceding(0).$(byText("Страхование вкладов")).click();
        $(".frame-head").shouldBe(text("Страхование вкладов"));
    }
}
