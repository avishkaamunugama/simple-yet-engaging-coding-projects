package computerFirmApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class chooseActorController {



    @FXML private Button btnAdmin;
    @FXML private Button btnEmp;

    @FXML public void tologin(ActionEvent evt) {  //display login page on a new stage
        try {
            Parent rootNode = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene sceneLogin = new Scene(rootNode, 415, 222);
            Stage stageLoginScreen = new Stage();
            stageLoginScreen.setTitle("Login");
            stageLoginScreen.setScene(sceneLogin);
            stageLoginScreen.show();
        }catch (Exception e){
            e.printStackTrace();  //tells you what the error was and where in the code this happened
        }
    }

    @FXML public void toEmpUI(ActionEvent evt){  //displays the employee page on a new stage
        try {

            Parent rootNode = FXMLLoader.load(getClass().getResource("empUI.fxml"));
            Scene sceneEmpUI = new Scene(rootNode,1003,563);
            Stage stageEmpUI = new Stage();
            stageEmpUI.setTitle("Employee Details");
            stageEmpUI.setScene(sceneEmpUI);
            stageEmpUI.show();
        } catch (IOException e) {
            e.printStackTrace();   //tells you what the error was and where in the code this happened
        }


    }
}

