package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.aliexpress.es.userInterfaces.ProductoUI.BTN_AGREGAR_CANTIDAD;
import static com.aliexpress.es.userInterfaces.ProductoUI.BTN_AGREGAR_CARRITO;

public class AgregarProductoCarritoTask implements Task {
    private Integer cantidadProducto;

    public AgregarProductoCarritoTask(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i < cantidadProducto; i++) {
            actor.attemptsTo(
                    Click.on(BTN_AGREGAR_CANTIDAD)
            );
        }
        actor.attemptsTo(
                Click.on(BTN_AGREGAR_CARRITO)
        );
    }

    public static AgregarProductoCarritoTask conCantidadProducto(Integer cantidadProducto) {
        return new AgregarProductoCarritoTask(cantidadProducto);
    }
}