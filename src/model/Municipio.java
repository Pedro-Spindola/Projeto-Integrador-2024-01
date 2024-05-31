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

package model;

/**
 *
 * @author Pedro Spindola
 * @date 29/05/2024
 * @brief Class Municipio
 */
public class Municipio {
    private int codigo;
    private String municipio, microrregiao, estado, regiaoGeografica, classIDHGeral, classIDHEducacao, classIDHLongevidade;
    private double area, populacao, domicilios, pibTotal, pibPerCapita, rendaMedia, rendaNominal, peaDia, idhGeral, idhEducacao, idhlongevidade, densidadeDemografica;

    public Municipio() {
    }

    public Municipio(int codigo, double populacao, double domicilios, String municipio, String microrregiao, String estado, String regiaoGeografica, double area, double pibTotal, double rendaMedia, double rendaNominal, double peaDia, double idhGeral, double idhEducacao, double idhlongevidade) {
        this.codigo = codigo;
        this.populacao = populacao;
        this.domicilios = domicilios;
        this.municipio = municipio;
        this.microrregiao = microrregiao;
        this.estado = estado;
        this.regiaoGeografica = regiaoGeografica;
        this.area = area;
        this.pibTotal = pibTotal;
        this.rendaMedia = rendaMedia;
        this.rendaNominal = rendaNominal;
        this.peaDia = peaDia;
        this.idhGeral = idhGeral;
        this.idhEducacao = idhEducacao;
        this.idhlongevidade = idhlongevidade;
        this.densidadeDemografica = calcularDensidadeDemografica(populacao, area);
        this.pibPerCapita = calcularPIBPerCapita(populacao, pibTotal);
        this.classIDHGeral = classificarIDHGeral(idhGeral);
        this.classIDHEducacao = classificarIDHEducacao(idhEducacao);
        this.classIDHLongevidade = classificarIDHLongevidade(idhlongevidade);
    }
    
    private double calcularDensidadeDemografica(double populacao, double area){
        double resultado = populacao / area;
        return resultado;
    }
    
    private double calcularPIBPerCapita(double populacao, double pib){
        double resultado = pib / populacao;
        return resultado;
    }
    
    private String classificarIDHGeral(double geral){
        String resultado;
            if(geral >= 0.8){
                resultado = "Muito Alto";
            }else if(geral < 0.8 && geral >= 0.7){
                resultado = "Alto";
            }else if(geral < 0.7 && geral >= 0.55){
                resultado = "Médio";
            }else{
                resultado = "Baixo";
            }
        return resultado;
    };
    
    private String classificarIDHEducacao(double educacao){
        String resultado;
            if(educacao >= 0.8){
                resultado = "Muito Alto";
            }else if(educacao < 0.8 && educacao >= 0.7){
                resultado = "Alto";
            }else if(educacao < 0.7 && educacao >= 0.55){
                resultado = "Médio";
            }else{
                resultado = "Baixo";
            }
        return resultado;
    };
    
    private String classificarIDHLongevidade(double longevidade){
        String resultado;
            if(longevidade >= 0.8){
                resultado = "Muito Alto";
            }else if(longevidade < 0.8 && longevidade >= 0.7){
                resultado = "Alto";
            }else if(longevidade < 0.7 && longevidade >= 0.55){
                resultado = "Médio";
            }else{
                resultado = "Baixo";
            }
        return resultado;
    };
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(String microrregiao) {
        this.microrregiao = microrregiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public void setRegiaoGeografica(String regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(double domicilios) {
        this.domicilios = domicilios;
    }

    public double getPibTotal() {
        return pibTotal;
    }

    public void setPibTotal(double pibTotal) {
        this.pibTotal = pibTotal;
    }

    public double getPibPerCapita() {
        return pibPerCapita;
    }

    public void setPibPerCapita(double pibPerCapita) {
        this.pibPerCapita = pibPerCapita;
    }

    public double getRendaMedia() {
        return rendaMedia;
    }

    public void setRendaMedia(double rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    public double getRendaNominal() {
        return rendaNominal;
    }

    public void setRendaNominal(double rendaNominal) {
        this.rendaNominal = rendaNominal;
    }

    public double getPeaDia() {
        return peaDia;
    }

    public void setPeaDia(double peaDia) {
        this.peaDia = peaDia;
    }

    public double getIdhGeral() {
        return idhGeral;
    }

    public void setIdhGeral(double idhGeral) {
        this.idhGeral = idhGeral;
    }

    public double getIdhEducacao() {
        return idhEducacao;
    }

    public void setIdhEducacao(double idhEducacao) {
        this.idhEducacao = idhEducacao;
    }

    public double getIdhlongevidade() {
        return idhlongevidade;
    }

    public void setIdhlongevidade(double idhlongevidade) {
        this.idhlongevidade = idhlongevidade;
    }

    public double getDensidadeDemografica() {
        return densidadeDemografica;
    }

    public void setDensidadeDemografica(double densidadeDemografica) {
        this.densidadeDemografica = densidadeDemografica;
    }

    public String getClassIDHGeral() {
        return classIDHGeral;
    }

    public void setClassIDHGeral(String classIDHGeral) {
        this.classIDHGeral = classIDHGeral;
    }

    public String getClassIDHEducacao() {
        return classIDHEducacao;
    }

    public void setClassIDHEducacao(String classIDHEducacao) {
        this.classIDHEducacao = classIDHEducacao;
    }

    public String getClassIDHLongevidade() {
        return classIDHLongevidade;
    }

    public void setClassIDHLongevidade(String classIDHLongevidade) {
        this.classIDHLongevidade = classIDHLongevidade;
    }
    
    
}
