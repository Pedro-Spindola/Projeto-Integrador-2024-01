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

import static java.lang.Double.parseDouble;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Municipio;
import javafx.stage.Stage;

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
    private TextField tfCodigo;
    
    @FXML
    private TextField tfNome;
    
    @FXML
    private TextField tfRegiao;
    
    @FXML
    private TextField tfEstado;
    
    @FXML
    private TextField tfMicrorregiao;
    
    @FXML
    private TextField tfArea;
    
    @FXML
    private TextField tfPopulacao;
    
    @FXML
    private TextField tfDomicilios;
    
    @FXML
    private TextField tfDensidade;
    
    @FXML
    private TextField tfPib;
    
    @FXML
    private TextField tfPerCapita;
    
    @FXML
    private TextField tfPea;
    
    @FXML
    private TextField tfRendaMedia;
    
    @FXML
    private TextField tfRendaNominal;
    
    @FXML
    private TextField tfIDHGeral;
    
    @FXML
    private TextField tfIHGEducacao;
    
    @FXML
    private TextField tfIHDLongevidade;
    
    @FXML
    private Label laRankingPopulacao;
    
    @FXML
    private Label laRankingPib;
    
    @FXML
    private Label laRankingPerCapita;
    
    @FXML
    private Label laRankingIDHGeral;
    
    @FXML
    private Label laDateUltimaAtualizacao;
    
    @FXML
    private ImageView imagemIDHGeral;
    
    @FXML
    private ImageView imagemIDHEducacao;
    
    @FXML
    private ImageView imagemIDHLongevidade;
    
    @FXML
    private ImageView imagemBandeiraMunicipio;
    
    @FXML
    private ImageView imagemMapsMunicipio;
    
    @FXML
    private Button sair;
    
    @FXML
    private Button editar;
    
    private String imagePathMuitoAlto = "/resources/icon/setaMuitoAlto.png";
    private String imagePathAlto = "/resources/icon/setaAlto.png";
    private String imagePathMedio = "/resources/icon/setaMedio.png";
    private String imagePathBaixo = "/resources/icon/setaBaixo.png";
    private String imagePathNull = "/resources/icon/null.png";
    private boolean isButtonPressed = false;
    
    @FXML
    private void FecharProgramaButton(ActionEvent event) {
        Platform.exit(); // Fecha o programa
    }
    
    @FXML
    private void AtivarButtonEditar() {
        if (!isButtonPressed) {
            String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: #e8bb00;";
            
            tfPopulacao.setStyle(estilo);
            tfDomicilios.setStyle(estilo);
            tfPib.setStyle(estilo);
            tfRendaMedia.setStyle(estilo);
            tfRendaNominal.setStyle(estilo);
            tfPea.setStyle(estilo);
            tfIDHGeral.setStyle(estilo);
            tfIHGEducacao.setStyle(estilo);
            tfIHDLongevidade.setStyle(estilo);

            tfPopulacao.setText(tfPopulacao.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfDomicilios.setText(tfDomicilios.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfPib.setText(tfPib.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfRendaMedia.setText(tfRendaMedia.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfRendaNominal.setText(tfRendaNominal.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfPea.setText(tfPea.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfIDHGeral.setText(tfIDHGeral.getText().replaceAll("[^\\d.]", ""));
            tfIHGEducacao.setText(tfIHGEducacao.getText().replaceAll("[^\\d.]", ""));
            tfIHDLongevidade.setText(tfIHDLongevidade.getText().replaceAll("[^\\d.]", ""));
    
            tfPopulacao.setEditable(true);
            tfDomicilios.setEditable(true);
            tfPib.setEditable(true);
            tfRendaMedia.setEditable(true);
            tfRendaNominal.setEditable(true);
            tfPea.setEditable(true);
            tfIDHGeral.setEditable(true);
            tfIHGEducacao.setEditable(true);
            tfIHDLongevidade.setEditable(true);
            
            editar.setText("Salvar");
            isButtonPressed = true;
        } else {
            String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: transparent;";
            
            tfPopulacao.setStyle(estilo);
            tfDomicilios.setStyle(estilo);
            tfPib.setStyle(estilo);
            tfRendaMedia.setStyle(estilo);
            tfRendaNominal.setStyle(estilo);
            tfPea.setStyle(estilo);
            tfIDHGeral.setStyle(estilo);
            tfIHGEducacao.setStyle(estilo);
            tfIHDLongevidade.setStyle(estilo);
            
            atualizarDados(comboBoxMunicipios.getValue());
            Program.calcularRanking();
            preencherDados(comboBoxMunicipios.getValue());
            
            tfPopulacao.setEditable(false);
            tfDomicilios.setEditable(false);
            tfPib.setEditable(false);
            tfRendaMedia.setEditable(false);
            tfRendaNominal.setEditable(false);
            tfPea.setEditable(false);
            tfIDHGeral.setEditable(false);
            tfIHGEducacao.setEditable(false);
            tfIHDLongevidade.setEditable(false);
            
            editar.setText("Editar");
            isButtonPressed = false;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obter a lista de municípios do programa principal
        ObservableList<String> listMunicipios = Program.getMunicipios();

        // Definir a lista de municípios no ComboBox
        comboBoxMunicipios.setItems(listMunicipios);
        
        // Definir por padrão o comboBox para selecionar a primeira linha.
        comboBoxMunicipios.getSelectionModel().selectFirst();
        
        // Método para retorna o valor escolhido pelo o ComboBox
        comboBoxMunicipios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                preencherDados(newValue);
            }
        });
    }    
    
    public void preencherDados(String municipioSelecionado) {
        Locale localeBrasil = new Locale("pt", "BR");

        // Formatar o valor para a modeda BRL
        NumberFormat nf = NumberFormat.getCurrencyInstance(localeBrasil);
        // Formato o numero para exibir.
        DecimalFormat df = new DecimalFormat("#,##0.##");
        
        // Laço para percorrer a lista dos meus objetos.
        for (Municipio municipios : Program.getObjMunicipios()) {
            if (municipios.getMunicipio().equalsIgnoreCase(municipioSelecionado)) {
                municipios.atualizarDados();
                
                tfCodigo.setText(String.valueOf(municipios.getCodigo()));
                tfNome.setText(municipios.getMunicipio());
                tfRegiao.setText(municipios.getRegiaoGeografica());
                tfEstado.setText(municipios.getEstado());
                tfMicrorregiao.setText(municipios.getMicrorregiao());
                tfArea.setText(String.valueOf(df.format(municipios.getArea()) + " km²"));
                tfPopulacao.setText(String.valueOf(df.format(municipios.getPopulacao()) + " hab"));
                tfDomicilios.setText(String.valueOf(df.format(municipios.getDomicilios())));
                tfDensidade.setText(String.valueOf(df.format(municipios.getDensidadeDemografica()) + " hab/km²"));
                tfPib.setText(String.valueOf(nf.format(municipios.getPibTotal())));
                tfPerCapita.setText(String.valueOf(nf.format(municipios.getPibPerCapita())));
                tfPea.setText(String.valueOf(nf.format(municipios.getPeaDia())));
                tfRendaMedia.setText(String.valueOf(nf.format(municipios.getRendaMedia())));
                tfRendaNominal.setText(String.valueOf(nf.format(municipios.getRendaNominal())));
                tfIDHGeral.setText(String.valueOf(municipios.getIdhGeral()));
                tfIHGEducacao.setText(String.valueOf(municipios.getIdhEducacao()));
                tfIHDLongevidade.setText(String.valueOf(municipios.getIdhlongevidade()));
                laRankingPopulacao.setText(String.valueOf(municipios.getRankPopulacao() + " º"));
                laRankingPib.setText(String.valueOf(municipios.getRankPIBTotal() + " º"));
                laRankingPerCapita.setText(String.valueOf(municipios.getRankPIBPerCapita() + " º"));
                laRankingIDHGeral.setText(String.valueOf(municipios.getRankIDHGeral() + " º"));
                laDateUltimaAtualizacao.setText(String.valueOf(municipios.getDateUltimaModificacao()));
                
                String imagePathBandeira = "/resources/bandeiras/" + municipios.getCodigo() + "_ban.png";
                String imagePathMapas = "/resources/maps/" + municipios.getCodigo() + "_map.png";
                
                Image carregarBandeira = new Image(getClass().getResourceAsStream(imagePathBandeira));
                imagemBandeiraMunicipio.setImage(carregarBandeira);
                Image carregarMapa = new Image(getClass().getResourceAsStream(imagePathMapas));
                imagemMapsMunicipio.setImage(carregarMapa);
                        
                if("Muito Alto".equals(municipios.getClassIDHGeral())){
                    // Carrega a nova imagem
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMuitoAlto));
                    // Define a nova imagem no ImageView
                    imagemIDHGeral.setImage(novaImagem);
                } else if("Alto".equals(municipios.getClassIDHGeral())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathAlto));
                    imagemIDHGeral.setImage(novaImagem);
                } else if("Médio".equals(municipios.getClassIDHGeral())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMedio));
                    imagemIDHGeral.setImage(novaImagem);
                } else if("Baixo".equals(municipios.getClassIDHGeral())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathBaixo));
                    imagemIDHGeral.setImage(novaImagem);
                } else {
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathNull));
                    imagemIDHGeral.setImage(novaImagem);
                }
                
                if("Muito Alto".equals(municipios.getClassIDHEducacao())){
                    // Carrega a nova imagem
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMuitoAlto));
                    // Define a nova imagem no ImageView
                    imagemIDHEducacao.setImage(novaImagem);
                } else if("Alto".equals(municipios.getClassIDHEducacao())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathAlto));
                    imagemIDHEducacao.setImage(novaImagem);
                } else if("Médio".equals(municipios.getClassIDHEducacao())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMedio));
                    imagemIDHEducacao.setImage(novaImagem);
                } else if("Baixo".equals(municipios.getClassIDHEducacao())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathBaixo));
                    imagemIDHEducacao.setImage(novaImagem);
                } else {
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathNull));
                    imagemIDHEducacao.setImage(novaImagem);
                }
                
                if("Muito Alto".equals(municipios.getClassIDHLongevidade())){
                    // Carrega a nova imagem
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMuitoAlto));
                    // Define a nova imagem no ImageView
                    imagemIDHLongevidade.setImage(novaImagem);
                } else if("Alto".equals(municipios.getClassIDHLongevidade())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathAlto));
                    imagemIDHLongevidade.setImage(novaImagem);
                } else if("Médio".equals(municipios.getClassIDHLongevidade())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathMedio));
                    imagemIDHLongevidade.setImage(novaImagem);
                } else if("Baixo".equals(municipios.getClassIDHLongevidade())){
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathBaixo));
                    imagemIDHLongevidade.setImage(novaImagem);
                } else {
                    Image novaImagem = new Image(getClass().getResourceAsStream(imagePathNull));
                    imagemIDHLongevidade.setImage(novaImagem);
                }
            }
        }
    }
    
    public void atualizarDados(String municipioSelecionado) {
        // Laço para percorrer a lista dos meus objetos.
        for (Municipio municipios : Program.getObjMunicipios()) {
            if (municipios.getMunicipio().equalsIgnoreCase(municipioSelecionado)) {
                try {
                    municipios.setPopulacao(parseDouble(tfPopulacao.getText()));
                    municipios.setDomicilios(parseDouble(tfDomicilios.getText()));
                    municipios.setPibTotal(parseDouble(tfPib.getText()));
                    municipios.setRendaMedia(parseDouble(tfRendaMedia.getText()));
                    municipios.setRendaNominal(parseDouble(tfRendaNominal.getText()));
                    municipios.setPeaDia(parseDouble(tfPea.getText()));
                    municipios.setIdhGeral(parseDouble(tfIDHGeral.getText()));
                    municipios.setIdhEducacao(parseDouble(tfIHGEducacao.getText()));
                    municipios.setIdhlongevidade(parseDouble(tfIHDLongevidade.getText()));
                    municipios.setDateUltimaModificacao(getDateTime());
                } catch (NumberFormatException e) {
                    // Se houver erro na conversão, não atualiza os valores
                    System.err.println("Erro ao converter para double: " + e.getMessage());
                }
            }
        }
    }
    
    public static String getDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formatter);
    }
}
