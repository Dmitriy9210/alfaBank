import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class TestAlfaBankInsuranceTests {

    @BeforeEach
    void setUp() {
        open("https://alfabank.ru/make-money/savings-account/");
    }

    @Test
    void workInsuranceUseSiblingTest() { //работа с sibling()
        $(".navigation").$(byText("Депозиты")).click();
        //проверяем переключилась ли страница и появилось ли окно Депозиты, а после берем 3 братский элемент от него
        $(".selected").shouldBe(text("Депозиты")).sibling(3).click();
        
        $(".frame-head").shouldHave(text("Страхование вкладов"));
    }

    @Test
    void workInsuranceUsePrecedingTest() { //работа с Preceding()
        $(".product-cell").preceding(0).$(byText("Страхование вкладов")).click();
        
        $(".frame-head").shouldHave(text("Страхование вкладов"));
    }

    @Test
    void workInsuranceUseParentTest() { // работа c Parent()
        $$(byTitle("Инвестиции")).get(2).parent().sibling(0).click(); //селекторы немного кривые, но моя задача проверить работу метода parent()
        
        $(".frame-head").shouldHave(text("Страхование вкладов"));

    }

    @Test
    void workInsuranceUseClosestTest() { //работа c Closest()
        $$(byTitle("Инвестиции"))
                .get(2)
                .parent()
                .closest("ul")
                .$(byText("Страхование вкладов"))
                .click(); //селекторы немного кривые
        
        $(".frame-head").shouldHave(text("Страхование вкладов"));
    }
}
