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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setResizable(false);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
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
    /*
    public static void calcularRanking(){
        // Percorrendo a lista com for
        for (int i = 0; i < municipios.size(); i++) {
            int rankPopulacao = 1, rankPIBTotal = 1, rankPIBPerCapita = 1, rankIDHGeral = 1;
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
            }
            municipios.get(i).setRankPopulacao(rankPopulacao);
            municipios.get(i).setRankPIBTotal(rankPIBTotal);
            municipios.get(i).setRankPIBPerCapita(rankPIBPerCapita);
            municipios.get(i).setRankIDHGeral(rankIDHGeral);
        }
    }*/
    
    public static ObservableList<String> getMunicipios() {
        return listMunicipios;
    }
    
    public static ObservableList<Municipio> getObjMunicipios() {
        return municipios;
    }
    
}
