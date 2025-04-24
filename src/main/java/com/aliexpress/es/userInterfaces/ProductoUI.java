package com.aliexpress.es.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductoUI {

    public static final Target TXT_PRECIO_UNIDAD = Target.the("Precio Unitario Producto")
            .locatedBy("//span[contains(@class, 'price-current')]");

    public static final Target BTN_AGREGAR_CANTIDAD = Target.the("Botón Agregar Cantidad Produco")
            .locatedBy("//div[contains(@class, 'btn-increase')]");

    public static final Target BTN_AGREGAR_CARRITO = Target.the("Botón Agregar Producto Al Carrito")
            .locatedBy("//button[contains(@class, 'add-to-cart')]");

    public static final Target BTN_CARRITO = Target.the("Botón Dirigir Al Carrito")
            .locatedBy("//a[@class='cart-summary-tocart']");
    
    public ProductoUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}

