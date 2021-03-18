import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import forms.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static helpers.GenericHelpers.*;
import static org.junit.Assert.assertEquals;

public class DemoAppStepdefs {
    private BookStore bookStore = new BookStore();
    private PracticeForm practiceForm = new PracticeForm();
    private Login login = new Login();
    private Profile profile = new Profile();
    private MenuOptions menuOptions = new MenuOptions();
    private Droppable droppable = new Droppable();

    @Given("user opens {string} in {string} browser")
    public void userOpens(String url, String browserName) {
      Configuration.browser = browserName.toLowerCase();
      open(url);
    }

    @When("user enters the text {string} as search input")
    public void userEntersTheText(String searchParameter) {
        bookStore.setSearchCriteria(searchParameter);
    }

    @And("clicks the search icon")
    public void clicksTheSearchIcon() {
        bookStore.clickSearchIcon();
    }


    @Then("user navigates to the application url {string}")
    public void userNavigatesToTheApplicationUrl(String applicationUrl) {
        assertEquals(getCurrentTabUrl(), applicationUrl);
    }

    @Then("{string} message is visible to user")
    public void messageIsVisibleToUser(String message) {
        assertEquals(bookStore.getNoBooksFoundMessage(), message);
    }

    @Then("{int} books are visible to user")
    public void searchResultsAreVisible(int numberOfBooks) {
        assertEquals(bookStore.getNumberOfBooks(), numberOfBooks);
    }

    @When("user enters first name as {string}")
    public void userEntersFirstNameAs(String firstName) {
        practiceForm.setFirstName(firstName);
    }

    @And("last name as {string}")
    public void lastNameAs(String lastName) {
        practiceForm.setLastName(lastName);
    }

    @And("email as {string}")
    public void emailAs(String email) {
        practiceForm.setEmail(email);
    }

    @And("select gender as {string}")
    public void selectGenderAsMale(String gender) {
        practiceForm.selectGender(gender);
    }

    @And("enters mobile number as {string}")
    public void entersMobileNumberAs(String mobileNumber) {
        practiceForm.setMobileNumber(mobileNumber);
    }

    @And("upload an image")
    public void uploadAnImage() {
        practiceForm.uploadImage();
    }

    @And("clicks submit button")
    public void clicksSubmitButton() {
        practiceForm.clickSubmit();
    }

    @Then("the confirmation pop up is visible to user")
    public void theConfirmationPopUpIsVisibleToUser() {
        practiceForm.getConfirmPopup().shouldBe(Condition.visible);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        login.setUsername(userName);
    }

    @And("password as {string}")
    public void passwordAs(String password) {
        login.setPassword(password);
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        login.clickLogin();
    }

    @And("clicks go to book store button")
    public void clicksGoToBookStoreButton() {
        profile.clickGoToBookStore();
    }

    @And("selects the book {string}")
    public void selectsBook(String bookName) {
        bookStore.selectBook(bookName);
    }

    @And("clicks add to your collection button")
    public void clicksAddToYourCollectionButton() {
        bookStore.addToCollection();
    }

    @And("confirms the pop up")
    public void confirmsThePopUp() {
        if(getBrowserName().equals("chrome")){
            closeModalDialog();
        }
        else{
            closeAlert();
        }
    }

    @And("clicks {string} menu option")
    public void clicksProfileMenuOption(String option) {
        menuOptions.openMenuOption(option);
    }

    @Then("the {string} book is visible to the collection of the user")
    public void theBookIsVisibleToHisHerCollection(String bookName) {
        profile.getBookFromCollection(bookName).shouldBe(Condition.visible);
    }

    @After("@addToCollection")
    public void deleteAddedBook() {
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.openMenuOption("Profile");

        Profile profile = new Profile();
        profile.deleteAllBooks();

        closeAlert();
    }

    @When("user drags and drops the ui element")
    public void userDragsAndDropsTheUiElement() {
        droppable.dragAndDrop();
    }

    @Then("{string} text is visible at the droppable area")
    public void theElementIsDroppedAtTheDesignatedArea(String expectedText) {
        assertEquals(droppable.getDroppedText(), expectedText);
    }
}
