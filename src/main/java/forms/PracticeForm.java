package forms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static helpers.GenericHelpers.scrollAndClickByCss;

public class PracticeForm {
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void selectGender(String gender) {
        $(By.xpath("//label[contains(text(), '" + gender + "')]")).click();
    }

    public void setMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
    }

    public void uploadImage() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File imageFile = new File(classLoader.getResource("TuhinImage.png").getFile());
        $("#uploadPicture").uploadFile(imageFile);
    }

    public void clickSubmit() {
        scrollAndClickByCss("#submit");
    }

    public SelenideElement getConfirmPopup() {
        return $("#example-modal-sizes-title-lg");
    }
}
