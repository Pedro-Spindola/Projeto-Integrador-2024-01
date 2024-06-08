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
import static java.lang.Double.parseDouble;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Municipio;
import util.Constraints;

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
    private TextField inCode;
        
    @FXML
    private Label laRankingPopulacao;
    
    @FXML
    private Label laRankingPib;
    
    @FXML
    private Label laRankingPerCapita;
    
    @FXML
    private Label laRankingIDHGeral;
    
    @FXML
    private Label laRankingIDHEducacao;
    
    @FXML
    private Label laRankingIDHLongevidade;
    
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
    
    @FXML 
    private Button pesquisar; 
    
    @FXML
    private Button exportar ;
    
    @FXML 
    private Button sobre; 
    
    private String imagePathMuitoAlto = "/resources/icon/setaMuitoAlto.png";
    private String imagePathAlto = "/resources/icon/setaAlto.png";
    private String imagePathMedio = "/resources/icon/setaMedio.png";
    private String imagePathBaixo = "/resources/icon/setaBaixo.png";
    private String imagePathNull = "/resources/icon/null.png";
    private boolean isButtonPressed = false;
    
    @FXML
    private void fecharProgramaButton(ActionEvent event) {
        if (isButtonPressed == false) {
            Platform.exit(); // Fecha o programa
        }
    }
    
    @FXML
    private void btnSobre(ActionEvent event) {
        // Btn Sobre / Cancelar
        if (isButtonPressed == false) {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/FXMLSobre.fxml"));
            Parent root = fxmlLoader.load();
            
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("EMGO");
            alert.setHeaderText(null);
            alert.setContentText("Deseja cancelar as alterações?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: transparent;";
                String btnEstilo = "-fx-background-color: #f9fff6; -fx-background-radius: 10; -fx-border-color: #f9fff6; -fx-border-radius: 10;";

                Constraints.setRemoveTextFieldDouble(tfPopulacao);
                Constraints.setRemoveTextFieldDouble(tfDomicilios);
                Constraints.setRemoveTextFieldDouble(tfPib);
                Constraints.setRemoveTextFieldDouble(tfRendaMedia);
                Constraints.setRemoveTextFieldDouble(tfRendaNominal);
                Constraints.setRemoveTextFieldDouble(tfPea);
                Constraints.setRemoveTextFieldDouble(tfIDHGeral);
                Constraints.setRemoveTextFieldDouble(tfIHGEducacao);
                Constraints.setRemoveTextFieldDouble(tfIHDLongevidade);

                tfPopulacao.setStyle(estilo);
                tfDomicilios.setStyle(estilo);
                tfPib.setStyle(estilo);
                tfRendaMedia.setStyle(estilo);
                tfRendaNominal.setStyle(estilo);
                tfPea.setStyle(estilo);
                tfIDHGeral.setStyle(estilo);
                tfIHGEducacao.setStyle(estilo);
                tfIHDLongevidade.setStyle(estilo);

                tfPopulacao.setEditable(false);
                tfDomicilios.setEditable(false);
                tfPib.setEditable(false);
                tfRendaMedia.setEditable(false);
                tfRendaNominal.setEditable(false);
                tfPea.setEditable(false);
                tfIDHGeral.setEditable(false);
                tfIHGEducacao.setEditable(false);
                tfIHDLongevidade.setEditable(false);

                preencherDados(comboBoxMunicipios.getValue());

                editar.setText("Editar");
                exportar.setText("Exportar");
                exportar.setStyle(btnEstilo);
                exportar.setTextFill(Color.web("#e8bb00"));
                sobre.setText("Sobre");
                isButtonPressed = false;
            } else {
                // VOLTAR
            }
        }
    }
    
    @FXML
    private void btnExporta(ActionEvent event) {
        // Btn exportar / deletar
        if (isButtonPressed == false) {
            Program.exportaCSV();
        } else{
            String selectedMunicipio = comboBoxMunicipios.getSelectionModel().getSelectedItem();
            if (selectedMunicipio != null) {
                // Remove o nome do município da lista
                Program.getMunicipios().remove(selectedMunicipio);
                // Remove o objeto Municipio correspondente da lista
                Program.getObjMunicipios().removeIf(municipio -> municipio.getMunicipio().equals(selectedMunicipio));
                
                String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: transparent;";
                String btnEstilo = "-fx-background-color: #f9fff6; -fx-background-radius: 10; -fx-border-color: #f9fff6; -fx-border-radius: 10;";

                Constraints.setRemoveTextFieldDouble(tfPopulacao);
                Constraints.setRemoveTextFieldDouble(tfDomicilios);
                Constraints.setRemoveTextFieldDouble(tfPib);
                Constraints.setRemoveTextFieldDouble(tfRendaMedia);
                Constraints.setRemoveTextFieldDouble(tfRendaNominal);
                Constraints.setRemoveTextFieldDouble(tfPea);
                Constraints.setRemoveTextFieldDouble(tfIDHGeral);
                Constraints.setRemoveTextFieldDouble(tfIHGEducacao);
                Constraints.setRemoveTextFieldDouble(tfIHDLongevidade);

                tfPopulacao.setStyle(estilo);
                tfDomicilios.setStyle(estilo);
                tfPib.setStyle(estilo);
                tfRendaMedia.setStyle(estilo);
                tfRendaNominal.setStyle(estilo);
                tfPea.setStyle(estilo);
                tfIDHGeral.setStyle(estilo);
                tfIHGEducacao.setStyle(estilo);
                tfIHDLongevidade.setStyle(estilo);

                tfPopulacao.setEditable(false);
                tfDomicilios.setEditable(false);
                tfPib.setEditable(false);
                tfRendaMedia.setEditable(false);
                tfRendaNominal.setEditable(false);
                tfPea.setEditable(false);
                tfIDHGeral.setEditable(false);
                tfIHGEducacao.setEditable(false);
                tfIHDLongevidade.setEditable(false);

                preencherDados(comboBoxMunicipios.getValue());

                editar.setText("Editar");
                exportar.setText("Exportar");
                exportar.setStyle(btnEstilo);
                exportar.setTextFill(Color.web("#e8bb00"));
                sobre.setText("Sobre");
                isButtonPressed = false;
            }
        }
    }
    
    @FXML
    private void ativarButtonEditar() {
        if (!isButtonPressed && comboBoxMunicipios.getSelectionModel().getSelectedItem() != null) {
            String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: #e8bb00;";
            String btnEstiloDelete = "-fx-background-color: #c12838; -fx-background-radius: 10; -fx-border-color: #c12838; -fx-border-radius: 10;";
            
            tfPopulacao.setText(tfPopulacao.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfDomicilios.setText(tfDomicilios.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfPib.setText(tfPib.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfRendaMedia.setText(tfRendaMedia.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfRendaNominal.setText(tfRendaNominal.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfPea.setText(tfPea.getText().replaceAll("[^\\d,]", "").replace(",", "."));
            tfIDHGeral.setText(tfIDHGeral.getText().replaceAll("[^\\d.]", ""));
            tfIHGEducacao.setText(tfIHGEducacao.getText().replaceAll("[^\\d.]", ""));
            tfIHDLongevidade.setText(tfIHDLongevidade.getText().replaceAll("[^\\d.]", ""));
            
            Constraints.validacaoParaNumeros(tfPopulacao);
            Constraints.validacaoParaNumerosDecimal(tfDomicilios);
            Constraints.validacaoParaNumerosDecimal(tfPib);
            Constraints.validacaoParaNumerosDecimal(tfRendaMedia);
            Constraints.validacaoParaNumerosDecimal(tfRendaNominal);
            Constraints.validacaoParaNumerosDecimal(tfPea);
            Constraints.validacaoParaNumerosDecimal(tfIDHGeral);
            Constraints.validacaoParaNumerosDecimal(tfIHGEducacao);
            Constraints.validacaoParaNumerosDecimal(tfIHDLongevidade);
            Constraints.validacaoParaNumerosDecimalComLimiteDeDigito(tfIDHGeral);
            Constraints.validacaoParaNumerosDecimalComLimiteDeDigito(tfIHGEducacao);
            Constraints.validacaoParaNumerosDecimalComLimiteDeDigito(tfIHDLongevidade);
            
            tfPopulacao.setStyle(estilo);
            tfDomicilios.setStyle(estilo);
            tfPib.setStyle(estilo);
            tfRendaMedia.setStyle(estilo);
            tfRendaNominal.setStyle(estilo);
            tfPea.setStyle(estilo);
            tfIDHGeral.setStyle(estilo);
            tfIHGEducacao.setStyle(estilo);
            tfIHDLongevidade.setStyle(estilo);
    
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
            exportar.setText("Deletar");
            exportar.setStyle(btnEstiloDelete);
            exportar.setTextFill(Color.web("#f9fff6"));
            sobre.setText("Cancelar");
            isButtonPressed = true;
        } else if(isButtonPressed){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("EMGO");
            alert.setHeaderText(null);
            alert.setContentText("Deseja salvar as alterações?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                atualizarDados(comboBoxMunicipios.getValue());
            } else {
                //NÃO SALVO
            }
            String estilo = "-fx-background-color: #F9FFF6; -fx-background-insets: 0; -fx-background-radius: 6; -fx-border-color: transparent;";
            String btnEstilo = "-fx-background-color: #f9fff6; -fx-background-radius: 10; -fx-border-color: #f9fff6; -fx-border-radius: 10;";
            
            Constraints.setRemoveTextFieldDouble(tfPopulacao);
            Constraints.setRemoveTextFieldDouble(tfDomicilios);
            Constraints.setRemoveTextFieldDouble(tfPib);
            Constraints.setRemoveTextFieldDouble(tfRendaMedia);
            Constraints.setRemoveTextFieldDouble(tfRendaNominal);
            Constraints.setRemoveTextFieldDouble(tfPea);
            Constraints.setRemoveTextFieldDouble(tfIDHGeral);
            Constraints.setRemoveTextFieldDouble(tfIHGEducacao);
            Constraints.setRemoveTextFieldDouble(tfIHDLongevidade);
            
            tfPopulacao.setStyle(estilo);
            tfDomicilios.setStyle(estilo);
            tfPib.setStyle(estilo);
            tfRendaMedia.setStyle(estilo);
            tfRendaNominal.setStyle(estilo);
            tfPea.setStyle(estilo);
            tfIDHGeral.setStyle(estilo);
            tfIHGEducacao.setStyle(estilo);
            tfIHDLongevidade.setStyle(estilo);
            
            tfPopulacao.setEditable(false);
            tfDomicilios.setEditable(false);
            tfPib.setEditable(false);
            tfRendaMedia.setEditable(false);
            tfRendaNominal.setEditable(false);
            tfPea.setEditable(false);
            tfIDHGeral.setEditable(false);
            tfIHGEducacao.setEditable(false);
            tfIHDLongevidade.setEditable(false);
            
            preencherDados(comboBoxMunicipios.getValue());
            
            editar.setText("Editar");
            exportar.setText("Exportar");
            exportar.setStyle(btnEstilo);
            exportar.setTextFill(Color.web("#e8bb00"));
            sobre.setText("Sobre");
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
        comboBoxMunicipios.getSelectionModel().clearSelection();
        
        // Método para retorna o valor escolhido pelo o ComboBox
        comboBoxMunicipios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                preencherDados(newValue);
            }
        });
        Constraints.validacaoParaNumeros(inCode);
    }    
    
    @FXML
    private void verificarCode() {
        String code = inCode.getText();
        if (!code.equals("0")) {
            for (Municipio municipios : Program.getObjMunicipios()) {
                if (String.valueOf(municipios.getCodigo()).equalsIgnoreCase(code)) {
                    String municipio = municipios.getMunicipio();
                    comboBoxMunicipios.getSelectionModel().select(municipio);
                    preencherDados(municipio);
                }
            }
        }else {
            // Adicionar janela informando o erro ("Município não encontrado.")
            inCode.setText("");
            comboBoxMunicipios.getSelectionModel().clearSelection();
        }
        inCode.setText("");
    }
    
    public void preencherDados(String municipioSelecionado) {
        Locale localeBrasil = new Locale("pt", "BR");
        calcularRanking();
                            
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
                laRankingIDHEducacao.setText(String.valueOf(municipios.getRankIDHEducacao()+ " º"));
                laRankingIDHLongevidade.setText(String.valueOf(municipios.getRankIDHLongevidade()+ " º"));
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
                    preencherDados(comboBoxMunicipios.getValue());
                } catch (NumberFormatException e) {
                    // Se houver erro na conversão, não atualiza os valores
                    System.err.println("Erro ao converter para double: " + e.getMessage());
                }
            }
        }
    }
    
    public static void calcularRanking(){
        
        ObservableList<Municipio> municipios = Program.getObjMunicipios();
     
        // Percorrendo a lista com for
        for (int i = 0; i < municipios.size(); i++) {
            int rankPopulacao = 1, rankPIBTotal = 1, rankPIBPerCapita = 1, rankIDHGeral = 1, rankIDHEducacao = 1, rankIDHLongevidade = 1;
            for (int j = 0; j < municipios.size(); j++){
                if(municipios.get(i).getPopulacao() < municipios.get(j).getPopulacao()){
                    rankPopulacao++;
                }
                if(municipios.get(i).getPibTotal()< municipios.get(j).getPibTotal()){
                    rankPIBTotal++;
                }
                if(municipios.get(i).getPibPerCapita()< municipios.get(j).getPibPerCapita()){
                    rankPIBPerCapita++;
                }
                if(municipios.get(i).getIdhGeral()< municipios.get(j).getIdhGeral()){
                    rankIDHGeral++;
                }
                if(municipios.get(i).getIdhEducacao()< municipios.get(j).getIdhEducacao()){
                    rankIDHEducacao++;
                }
                if(municipios.get(i).getIdhlongevidade()< municipios.get(j).getIdhlongevidade()){
                    rankIDHLongevidade++;
                }
            }
            municipios.get(i).setRankPopulacao(rankPopulacao);
            municipios.get(i).setRankPIBTotal(rankPIBTotal);
            municipios.get(i).setRankPIBPerCapita(rankPIBPerCapita);
            municipios.get(i).setRankIDHGeral(rankIDHGeral);
            municipios.get(i).setRankIDHEducacao(rankIDHEducacao);
            municipios.get(i).setRankIDHLongevidade(rankIDHLongevidade);
        }
    }
        
    public static String getDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formatter);
    }
}
