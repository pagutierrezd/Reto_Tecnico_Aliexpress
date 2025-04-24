package com.aliexpress.es.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

import java.math.BigDecimal;

import static com.aliexpress.es.userInterfaces.CarritoComprasUI.TXT_CANTIDAD;
import static com.aliexpress.es.userInterfaces.CarritoComprasUI.TXT_SUBTOTAL;
import static com.aliexpress.es.utils.Utils.obtenerPrecio;


public class ValidarPrecioCarrito implements Question<Boolean> {
    protected BigDecimal precioUnitario;

    public ValidarPrecioCarrito(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String valorComoTexto = Attribute.of(TXT_CANTIDAD).named("value").answeredBy(actor);
        int cantidad = Integer.parseInt(valorComoTexto);
        BigDecimal subtotal = obtenerPrecio(TXT_SUBTOTAL.resolveFor(actor).getText());

        return precioUnitario.multiply(BigDecimal.valueOf(cantidad)).equals(subtotal);
    }

    public static Question<Boolean> value(BigDecimal precioUnitario) {
        return new ValidarPrecioCarrito(precioUnitario);
    }
}