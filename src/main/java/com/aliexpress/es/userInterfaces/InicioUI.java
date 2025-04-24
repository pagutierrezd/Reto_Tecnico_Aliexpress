package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioUI {

    public static final Target TXT_BUSCADOR = Target.the("Campo Buscador Inicio")
            .locatedBy("//input[@name='searchWords']");

    public InicioUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}