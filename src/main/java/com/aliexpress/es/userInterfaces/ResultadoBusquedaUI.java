package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultadoBusquedaUI {

    public static final Target LBL_PRODUCTO = Target.the("Label Producto Resultado Busqueda")
            .locatedBy("//h3[contains(text(), '{0}')]");

    public ResultadoBusquedaUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}