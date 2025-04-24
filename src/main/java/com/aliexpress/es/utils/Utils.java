package com.aliexpress.es.utils;

import java.math.BigDecimal;

public class Utils {

    public static BigDecimal obtenerValor(String texto) {
        String limpio = texto.replaceAll("[^\\d,]", "");
        String conPuntoDecimal = limpio.replace(",", ".");
        return new BigDecimal(conPuntoDecimal);
    }
}