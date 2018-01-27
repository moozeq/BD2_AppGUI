import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("app.fxml"));
        root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.init();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Information about public transport");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
