package com.example.the_elite_driving_school_management_system.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public TextField signInUserName;
    public TextField signInEmail;
    public PasswordField signInPassword;
    public Label SignUptxtButton;
    public TextField signUpSectionUserName;
    public TextField signUpsecssionEmail;
    public PasswordField signUpSecssionPassword;
    public Label signInMessageButton;
    public AnchorPane ANCSignIn;
    public AnchorPane ANCSignUp;

    String namePattern = "^[A-Za-z ]{2,}$";
    String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";


    public void btnSignIn(ActionEvent actionEvent) {
    }

    public void btnSignUp(ActionEvent actionEvent) {
        //username part
         String name= signUpSectionUserName.getText();
        if (name.matches(namePattern)){
            signUpSectionUserName.setStyle("-fx-border-color: #2c3e50; -fx-border-width: 2px;");
            System.out.println("name valid");
            String validName = signUpSectionUserName.getText();

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Name is not valid");
            alert.setHeaderText(null);
            signUpSectionUserName.clear();
            signUpSectionUserName.requestFocus();
            signUpSectionUserName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        /// //////////////////////////////////////////////////////////////////////////
        String password = signUpSecssionPassword.getText();
        /// /////////////////////////////////////////////////////////////////////////
        //email part
        if (password.matches(emailPattern)){
            String email=signUpsecssionEmail.getText();
            if (email.matches(emailPattern)){
                String validEmail = signUpsecssionEmail.getText();
                System.out.println("email valid");
                signUpsecssionEmail.setStyle("-fx-border-color: #2c3e50; -fx-border-width: 2px;");
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email is not valid");
                alert.setHeaderText(null);
                signUpsecssionEmail.clear();
                signUpsecssionEmail.requestFocus();
                signUpsecssionEmail.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signInAnimation();
        SignUptxtButton.setOnMouseClicked(event -> {
            clearAllText();
            ANCSignIn.setVisible(false);
            ANCSignUp.setVisible(true);
            //SignUp Animation
            double width=445;
           ANCSignUp.setTranslateX(width);
           TranslateTransition slide2 = new TranslateTransition();
           slide2.setDuration(Duration.seconds(0.7));
           slide2.setNode(ANCSignUp);
           slide2.setFromX(width);
           slide2.setToX(0);
           slide2.play();
        });

        signInMessageButton.setOnMouseClicked(event -> {
            clearAllText();
            ANCSignUp.setVisible(false);
            ANCSignIn.setVisible(true);
            signInAnimation();
        });
    }
    public void signInAnimation(){
        ANCSignIn.setTranslateX(-400);

        //signIn Animation
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(ANCSignIn);
        slide.setFromX(-400);
        slide.setToX(0);
        slide.play();
    }
    public void clearAllText(){
        signInUserName.clear();
        signInEmail.clear();
        signInPassword.clear();
        signUpsecssionEmail.clear();
        signUpSecssionPassword.clear();
        signUpSectionUserName.clear();

    }
}
