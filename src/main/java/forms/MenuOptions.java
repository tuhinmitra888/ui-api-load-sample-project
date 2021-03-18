package forms;

import static helpers.GenericHelpers.scrollAndClickByXpath;

public class MenuOptions {
    public void openMenuOption(String option) {
        scrollAndClickByXpath("//span[contains(text(), '" + option + "')]");
    }
}
