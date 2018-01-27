import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Created by Ted on 27.01.2018.
 */
public class RouteFinderController {
    @FXML
    ChoiceBox stopChooserFrom; //choose stop from (3rd point)
    @FXML
    ChoiceBox stopChooserTo; //chose stop to (3rd point)
    @FXML
    Slider routeMinutes; //user sets on how many max minutes can wait (3rd point)
    @FXML
    Label directRoute; //show up when there's direct route between stops (3rd point)
    @FXML
    Label noRoutes; //show up when there're no available routes between stops (3rd point)

    void init() {
//        Set<Stop> stops = new Set();
//        stopChooserFrom.setItems(stops);
//        stopChooserTo.setItems(stops);
    }

    void setLabel(Label label) {
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
        visiblePause.setOnFinished(event -> label.setVisible(false));
        visiblePause.play();
    }

    /*
    return:
        >0 if there is connection with one change
        0 if there is direct connection
        <0 if there're no available connections
     */
//    int checkIfDirectConnection(Stop stopFrom, Stop stopTo) {
//
//    }

    public void checkRoute() {
//        int connection = checkIfDirectConnection(stopChooserFrom.getValue(), stopChooserTo.getValue()); //needs to implement
        int connection = 1;
        if (connection == 0) { //there is direct connection
            setLabel(directRoute);
            return;
        }
        else if (connection < 0) { //there're no connections available
            setLabel(noRoutes);
            return;
        }
        else { //there's connection with change, needs to fill fields leaveTime, firstLine, stopBetween, secondLine
            directRoute.setVisible(false);
            noRoutes.setVisible(false);

//                String leaveTime = getLeaveTime(); //need to get strings about these information
//                String firstLine = getFirstLine();
//                String stopBetween = getStopBetween();
//                String secondLine = getSecondLine();

            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("routeInfo.fxml"));
                root = fxmlLoader.load();
                RouteInfoController controller = fxmlLoader.getController();
//                controller.init(leaveTime, firstLine, stopBetween, secondLine);
                controller.init("Leave Time", "First Time", "Stop Between", "Second Line");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Route information");
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
