package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;


@Tag("selenide")
public class AndroidSelenideTests extends TestBase {
    @DisplayName("BrowserStack simple test")
    @Test
    void searchTest() {

        step("Press skip button", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });

        step("Verify content found", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }
}
