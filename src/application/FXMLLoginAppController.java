package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FXMLLoginAppController implements Initializable {
    
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @FXML
    private void loginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Login autenticado
            loginMessage.setText("Login Autenticado!");
            try {
                Program.setRoot("FXMLDocument");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Credenciais inválidas
            loginMessage.setText("Usuário ou Senha inválidos");
        }
    }
    
    // Atributos FXML para os campos do formulário
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
}