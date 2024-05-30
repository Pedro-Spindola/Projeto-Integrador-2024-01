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
    private String municipio, microrregiao, estado, regiaoGeografica;
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
    }
    
    private double calcularDensidadeDemografica(double populacao, double area){
        double resultado = populacao / area;
        return resultado;
    }
    
    private double calcularPIBPerCapita(double populacao, double pib){
        double resultado = pib / populacao;
        return resultado;
    }
}
