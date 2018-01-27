import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Controller {

    @FXML
    ChoiceBox stopChooser1; //choose to see timetable (2nd point)
    @FXML
    ChoiceBox stopChooser2; //choose to see drivers info (1st point)

    @FXML
    Slider hours; //user sets on which hour bus/tram.. arrives (1st point)
    @FXML
    Slider minutes; //user sets on which minutes bus/tram.. arrives (1st point)
    @FXML
    Slider months; //user sets in how many months drivers licenses expire (4th point)

    @FXML
    TextField lineNumber; //user enters line number (1st point)
    @FXML
    TextArea driverInfo; //needs to display drivers info (1st point)

    @FXML
    ListView table; //table which displays drivers with licences near expiration date or timetable for stop (2nd and 4th point)

    private Set<String> stops;

    void init() { //initialize stops lists
        if (!stopChooser1.getItems().isEmpty())
            stopChooser1.getItems().clear();
        if (!stopChooser2.getItems().isEmpty())
        stopChooser2.getItems().clear();
//        Set<Stop> stops = new HashSet(); //get stops from database
//        stopChooser1.getItems().addAll(stops);
//        stopChooser2.getItems().addAll(stops);

        //test data, need to remove this in app
        stops = new HashSet<>(Arrays.asList("Berlin", "Moscow", "New York"));
        stopChooser1.getItems().addAll(stops);
        stopChooser2.getItems().addAll(stops);
        //--------------------
    }

    public void checkDriverInformation() {
        try {
            int line = Integer.parseInt(lineNumber.getText()); //get which line
            int hour = (int)Math.round(hours.getValue());
            int minute = (int)Math.round(minutes.getValue());
//            Stop stopCourse = stopChooser2.getValue(); //get which Stop
//            String driverInformation = getDriverInfo(stopCourse, line, hour, minute); //needs to implement function returning drivers info
//            driverInfo.setText(driverInformation);

            //test data, need to remove this in app

            driverInfo.setText("Mr Potato Tomato license 8219374" + "\nat line: " + line +
                               "\nat time: " + hour + ":" + minute +
                                "\nat stop: " + stopChooser2.getValue());
            //---------------------------------
        } catch (Exception e) {
            return;
        }
    }
    public void checkTimetable () {
        if (!table.getItems().isEmpty())
            table.getItems().clear();

//        Stop stopCourse = stopChooser1.getValue(); //get which Stop's timetable needs to be display
//        Set<StopCourse> stopCourses = stopCourse.getStopCourses();
//        for (StopCourse stCourse : stopCourses)
//            table.getItems().add(stCourse.getTime().toString());

        //test data, need to remove this in app
        int i = 8;
        int j = 11;
        for (int k = 0; k < 12; ++k)
            table.getItems().add(i++ + ":" + (++j + 2));
        //-------------------------------
    }
    public void checkDriversLicenses() {
        if (!table.getItems().isEmpty())
            table.getItems().clear();
        int monthsExp = (int)Math.round(months.getValue());
//        Set<Driver> drivers = getDriversWhoseDriverLicenseExpiresIn(monthsExp);
//        for (Driver driver : drivers)
//            table.getItems().add(stCourse.getTime().toString());

        //test data, need to remove this in app
        int i = 8;
        int j = 21;
        for (int k = 0; k < monthsExp; ++k)
            table.getItems().add("Mr Potato" + i++ + ", license exp date: " + k);
        //-------------------------------
    }
    public void openRouteFinder() {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("routeFinder.fxml"));
            root = fxmlLoader.load();
            RouteFinderController controller = fxmlLoader.getController();
            controller.init();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Route finder");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            return;
        }
    }
}
