package computerFirmApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class loginController {
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private Button btnLogin;


    @FXML public void login(ActionEvent evt){
        String username = txtUsername.getText().trim();   //remove preceding and following white spaces
        String password = txtPassword.getText().trim();

        if (username.equals("admin") && (password.equals("1234"))){   //sets the username and password
            try {

                System.out.println("Successfully logged in");
                Parent rootNode = FXMLLoader.load(getClass().getResource("adminUI.fxml"));
                Scene sceneNewScreen =new Scene(rootNode,1343,636);
                Stage stageMainScreen = (Stage) ((Node) evt.getSource()).getScene().getWindow();   //opens the new page in the same stage rather than creating a new one
                stageMainScreen.setTitle("Admin Account");
                stageMainScreen.setScene(sceneNewScreen);
                stageMainScreen.show();
                stageMainScreen.setMaximized(true); // open as a maximised window
            }catch (Exception e){
                e.printStackTrace();   //tells you what the error was and where in the code this happened
                System.out.println("Please check your username adn password");
            }
        }

        else{
            Alert message =new Alert(Alert.AlertType.ERROR,"Check your username and password");
            message.showAndWait();   //keeps showing until the user manually closes the windows
        }
    }


}


