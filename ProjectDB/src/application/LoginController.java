package application;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();

    @FXML
    private TextField txtUser;

    @FXML
    private Label isConnected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        if (loginModel.isDbConnected()) {
            isConnected.setText("Connected");
        } else {

            isConnected.setText("Not Connected");
        }
    }

    public void LoginBtn(ActionEvent event) {
        String userName = txtUser.getText();
        try {
            if (loginModel.isLogin(userName)){
                isConnected.setText("You have been here before.");
                }else {
                    isConnected.setText("You are new!");
                    String query = "INSERT INTO dbProject(UserID) VALUES(userName)";
                }
        }
        catch(Exception e){
            isConnected.setText("Something went horribly wrong.");
            }
        }


    }

