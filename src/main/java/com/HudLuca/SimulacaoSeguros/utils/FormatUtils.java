package com.HudLuca.SimulacaoSeguros.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtils {

    public static String formatDinheiro(Double d){
        if (d != null){
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            return numberFormat.format(d);
        }
        return "";
    }
}
