package forms;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static helpers.GenericHelpers.scrollAndClickByCss;
import static helpers.GenericHelpers.scrollAndClickByXpath;

public class Profile {
    public void clickGoToBookStore() {
        scrollAndClickByCss("#gotoStore");
    }

    public SelenideElement getBookFromCollection(String bookName) {
        return $(By.linkText(bookName));
    }

    public void deleteAllBooks() {
        scrollAndClickByXpath("//button[contains(text(), 'Delete All Books')]");
        $("#closeSmallModal-ok").click();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 3);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
