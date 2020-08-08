import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestAlfaBankDeposit {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void openArchiveDeposit() {
        open("https://alfabank.ru/make-money/savings-account/");
        //переходим по Депозитам
        $(".navigation").$(byText("Депозиты")).click();
        //проверяем переключилась ли страница и появилось ли окно Депозиты
        $(".selected").shouldBe(text("Депозиты"));
        //находим Архивные депозиты и переходим в них
        $("html").$(byText("Архивные депозиты")).click();
        //проверяем, что перешли в Архивные депозиты
        $(".layout__content.content").should(text("Архивные депозиты"));
//проверяем, что 3 пункта
        $$(".product-cell__cell").shouldHave(size(3));
        //todo проыеряем, что элементы видимы, возможно не правильно реализовал и проверка не работает
        $$(".product-cell__cell").find(visible);
    }
}
