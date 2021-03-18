package forms;

import static com.codeborne.selenide.Selenide.$;

public class Login {
    public void setUsername(String userName) {
        $("#userName").setValue(userName);
    }

    public void setPassword(String password) {
        $("#password").setValue(password);
    }

    public void clickLogin() {
        $("#login").click();
    }
}
