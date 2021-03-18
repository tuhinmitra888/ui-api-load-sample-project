package forms;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.GenericHelpers.scrollAndClickByXpath;

public class BookStore {
    public void setSearchCriteria(String searchParameter) {
        $("#searchBox").setValue(searchParameter);
    }

    public void clickSearchIcon() {
        $("#basic-addon2").click();
    }

    public String getNoBooksFoundMessage() {
        return $(".rt-noData").getText();
    }

    public int getNumberOfBooks() {
        return $$(By.xpath(".//div[@class='rt-td']/img")).size();
    }

    public void selectBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(bookName)));
        $(By.linkText(bookName)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addNewRecordButton")));
    }

    public void addToCollection() {
        scrollAndClickByXpath("//button[contains(text(), 'Add To Your Collection')]");
    }
}
