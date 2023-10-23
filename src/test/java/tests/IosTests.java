package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("ios")
public class IosTests extends TestBase {
    @DisplayName("Проверка соответствия введенного текста в поле поиска")
    @Test
    void successfulSearchTest() {
        step("Нажать на поле поиска", () -> {
            $(id("Text Button")).click();
        });

        step("Ввести запрос 'test request и нажать на Enter'", () -> {
            $(id("Text Input")).sendKeys("test request");
            $(id("Text Input")).pressEnter();
        });

        step("Проверка введенного текста на соответствие", () -> {
            assertThat($(id("Text Output")).getText()).isEqualTo("test request");
        });
    }
}
