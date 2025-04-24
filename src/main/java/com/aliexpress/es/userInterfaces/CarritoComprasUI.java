package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoComprasUI {

    public static final Target TXT_PRODUCTO_CARRITO = Target.the("Producto En Carrito")
            .locatedBy("//a[contains(text(), '{0}')]");

    public static final Target TXT_CANTIDAD = Target.the("Cantidad Producto Carrito")
            .locatedBy("//input[contains(@class, 'input-number')]");

    public static final Target TXT_SUBTOTAL = Target.the("Subtotal Carrito")
            .locatedBy("//div[normalize-space()='Subtotal']/following-sibling::div//span");

    public CarritoComprasUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
