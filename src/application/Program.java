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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Municipio;

/**
 *
 * @author Pedro Spindola
 * @date 29/05/2024
 * @brief Class Program
 */
public class Program extends Application {
    private static ObservableList<String> listMunicipios = FXCollections.observableArrayList();
    private static ObservableList<Municipio> municipios = FXCollections.observableArrayList();
    private static Scene scene;
    private static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.setResizable(false);
        
        scene = new Scene(loadFXML("/view/FXMLLoginApp"));
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args){
        String path = "C:\\Projeto Integrador\\in\\01.ProjetoIntegrador_BaseMunicipios_In.csv";
        Municipio municipio;
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))){
            String line = br.readLine();
            
            while((line = br.readLine()) != null){
                String[] data = line.split(";");
                int codigo = Integer.parseInt(data[0]);
                double populacao = Double.parseDouble(data[6].replace(".", "").replace(",", "."));
                double domicilios = Double.parseDouble(data[7].replace(".", "").replace(",", "."));
                String municpio = data[1];
                listMunicipios.add(municpio);
                String microrregiao = data[2];
                String estado = data[3];
                String regiaoGeografica = data[4];
                double area = Double.parseDouble(data[5].replace(".", "").replace(",", "."));
                double pibTotal = Double.parseDouble(data[8].replace(".", "").replace(",", "."));
                double rendaMedia = Double.parseDouble(data[10].replace(".", "").replace(",", "."));
                double rendaNominal = Double.parseDouble(data[11].replace(".", "").replace(",", "."));
                double peaDia = Double.parseDouble(data[12].replace(".", "").replace(",", "."));
                double idhGeral = Double.parseDouble(data[9].replace(".", "").replace(",", "."));
                double idhEducacao = Double.parseDouble(data[13].replace(".", "").replace(",", "."));
                double idhlongevidade = Double.parseDouble(data[14].replace(".", "").replace(",", "."));
                municipio = new Municipio(codigo, populacao, domicilios, municpio, microrregiao, estado, regiaoGeografica, area, pibTotal, rendaMedia, rendaNominal, peaDia, idhGeral, idhEducacao, idhlongevidade);
                municipios.add(municipio);
                
            }
            
        }catch(IOException e){
            System.out.println("Error> " + e.getMessage());
        }
        launch(args); 
    }
    
    public static void exportaCSV(){
        String path = "C:\\Projeto Integrador";
        try{
            File outDiretorio = new File(path + "/out");
            if (!outDiretorio.exists()) {
                outDiretorio.mkdir();
            }
            
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\out\\01.ProjetoIntegrador_BaseMunicipios_Out.csv"))) {
            Locale localeBrasil = new Locale("pt", "BR");
                            
        // Formatar o valor para a modeda BRL
        NumberFormat nf = NumberFormat.getCurrencyInstance(localeBrasil);
        // Formato o numero para exibir.
        DecimalFormat df = new DecimalFormat("#,##0.##");
            String lineMenu = "Código IBGE;Municípios;Microrregião;Estado;Região Geográfica;Área Km²;População;Domicílios;PIB Total (R$ mil);IDH - Índice de Desenv. Humano;Renda Média;Renda Nominal;PEA Dia;IDH - Dimensão Educação;IDH - Dimensão Longevidade; Última Atualização";
            bw.write(lineMenu);
            bw.newLine();
                for (Municipio municipio : municipios) {
                    String codigo = (String.valueOf(municipio.getCodigo()));
                    String nome = (municipio.getMunicipio());
                    String regiao = (municipio.getRegiaoGeografica());
                    String estado = (municipio.getEstado());
                    String micro = (municipio.getMicrorregiao());
                    String area = (String.valueOf(df.format(municipio.getArea())));
                    String populacao = (String.valueOf(df.format(municipio.getPopulacao())));
                    String domicilios = (String.valueOf(df.format(municipio.getDomicilios())));
                    String pib = (String.valueOf(nf.format(municipio.getPibTotal() / 1000).replaceAll("[^\\d.,]", "")));
                    String pea = (String.valueOf(nf.format(municipio.getPeaDia()).replaceAll("[^\\d.,]", "")));
                    String rendaMedia = (String.valueOf(nf.format(municipio.getRendaMedia()).replaceAll("[^\\d.,]", "")));
                    String rendaNominal = (String.valueOf(nf.format(municipio.getRendaNominal()).replaceAll("[^\\d.,]", "")));
                    String idhGeral = (String.valueOf(municipio.getIdhGeral()));
                    String idhEducacao = (String.valueOf(municipio.getIdhEducacao()));
                    String idhLongevidade = (String.valueOf(municipio.getIdhlongevidade()));
                    String DateUltimaAtualizacao = (String.valueOf(municipio.getDateUltimaModificacao()));
                    
                    String line = codigo + ";" + nome + ";" + regiao + ";" + estado + ";" + micro + ";" + area + ";" + populacao + ";" + domicilios + ";" + pib + ";" + idhGeral + ";" + rendaMedia + ";" + rendaNominal + ";" + pea + ";" + idhEducacao + ";" +idhLongevidade + ";" + DateUltimaAtualizacao;
                    bw.write(line);
                    bw.newLine();
                }
            }
        }catch(IOException e){
            System.out.println("Error> " + e.getMessage());
        }
    }
    
    public static ObservableList<String> getMunicipios() {
        return listMunicipios;
    }
    
    public static ObservableList<Municipio> getObjMunicipios() {
        return municipios;
    }
    
}
