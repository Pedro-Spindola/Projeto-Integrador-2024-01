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

package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;


/**
 *
 * @author Pedro Spindola
 * @date 02/06/2024
 * @brief Class Constraints
 */
public class Constraints {

    public static void validacaoParaNumerosDecimal(TextField txt) {
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*([\\.]\\d*)?")) {
                return change;
            }
            return null;
        });
        txt.setTextFormatter(formatter);
    }
    
    public static void validacaoParaNumeros(TextField txt) {
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        });
        txt.setTextFormatter(formatter);
    }
    
    public static void validacaoParaNumerosDecimalComLimiteDeDigito(TextField txt) {
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*([\\.]\\d{0,3})?")) {
                return change;
            }
            return null;
        });
        txt.setTextFormatter(formatter);
    }
    
    public static void setRemoveTextFieldDouble(TextField txt) {
        txt.setTextFormatter(null);
    }
}
