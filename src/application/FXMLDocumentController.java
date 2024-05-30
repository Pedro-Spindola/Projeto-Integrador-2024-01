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
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Pedro Spindola
 * @date 29/05/2024
 * @brief Class FXMLDocumentController
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxMunicipios;
    
    @FXML
    private TextField tfCodigo, tfNome, tfRegiao, tfEstado, tfMicrorregiao, tfArea, tfPopulacao, tfDomicilios, tfDensidade, tfPib, tfPerCapita, tfPea, tfRendaMedia, tfRendaNominal, tfIDHGeral, tfIHGEducacao, tfIHDLongevidade;
    
    @FXML
    private Button sair, editar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obter a lista de municípios do programa principal
        ObservableList<String> listMunicipios = Program.getMunicipios();

        // Definir a lista de municípios no ComboBox
        comboBoxMunicipios.setItems(listMunicipios);
        
        // TODO
    }    
    
}
