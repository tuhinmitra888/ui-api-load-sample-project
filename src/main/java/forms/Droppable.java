package forms;

import static com.codeborne.selenide.Selenide.$;

public class Droppable {

    public void dragAndDrop() {
        $("#draggable").dragAndDropTo("#droppable");
    }

    public String getDroppedText() {
        return $("#droppable").getText();
    }
}
