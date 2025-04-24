package com.aliexpress.es.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.aliexpress.es.userInterfaces.CarritoComprasUI.TXT_PRODUCTO_CARRITO;

public class ValidarProductoCarrito implements Question<Boolean> {
    protected String producto;

    public ValidarProductoCarrito(String producto) {
        this.producto = producto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return TXT_PRODUCTO_CARRITO.of(producto).resolveFor(actor).getText().contains(producto);
    }

    public static Question<Boolean> value(String producto) {
        return new ValidarProductoCarrito(producto);
    }
}