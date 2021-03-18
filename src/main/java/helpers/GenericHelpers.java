package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.$;

public class GenericHelpers {
    public static String getCurrentTabUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public static void closeModalDialog() {
        WebDriverRunner.getWebDriver().switchTo().activeElement().click();
    }

    public static void closeAlert() {
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

    public static void scrollAndClickByCss(String cssSelector) {
        SelenideElement element = $(cssSelector);
        element.scrollTo();
        element.click();
    }

    public static void scrollAndClickByXpath(String locator) {
        SelenideElement element = $(By.xpath(locator));
        element.scrollTo();
        element.click();
    }

    public static String getBrowserName(){
        Capabilities cap = ((RemoteWebDriver)WebDriverRunner.getWebDriver()).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }
}
