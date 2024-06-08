/*
 * Copyright (C) 2024 Pedro Spindola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package controller;

import application.Program;
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

/**
 *
 * @author Pedro Spindola
 * @date 29/05/2024
 * @brief Class FXMLLoginAppController
 */

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
                Program.setRoot("/view/FXMLDocument");
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