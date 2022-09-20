package computerFirmApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{     //opens the application with the choose service sector page
        Parent root = FXMLLoader.load(getClass().getResource("chooseActor.fxml"));
        primaryStage.setTitle("Computer Consultancy Firm App");
        primaryStage.setScene(new Scene(root, 385, 318));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
