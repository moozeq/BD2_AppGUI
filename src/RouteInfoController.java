import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by Ted on 27.01.2018.
 */
public class RouteInfoController {
    @FXML
    TextArea firstLine; //needs to display which line should ride first (3rd point)
    @FXML
    TextArea stopBetween; //needs to display which stop is between lines (3rd point)
    @FXML
    TextArea secondLine; //needs to display which line should ride to destination (3rd point)

    public void init(String _firstLine, String _stopBetween, String _secondLine) {
        firstLine.setText(_firstLine); //which line needs to ride first
        stopBetween.setText(_stopBetween); //on which stop needs to get out
        secondLine.setText(_secondLine); //which line needs to ride next to destination
    }
}
