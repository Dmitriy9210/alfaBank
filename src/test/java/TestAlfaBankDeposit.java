import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestAlfaBankDepositTests {

    @Test
    public void openArchiveDepositTest() {
        open("https://alfabank.ru/make-money/savings-account/");
        
        //переходим по Депозитам
        $(".navigation").$(byText("Депозиты")).click();
        //проверяем переключилась ли страница и появилось ли окно Депозиты
        $(".selected").shouldBe(text("Депозиты"));
        //находим Архивные депозиты и переходим в них
        $("html").$(byText("Архивные депозиты")).click();
        //проверяем, что перешли в Архивные депозиты
        $(".layout__content.content").should(text("Архивные депозиты"));

        //todo проыеряем, что есть 3 видимых элемента
        $$(".product-cell__cell").filter(visible).shouldHave(size(3));
    }
}
