package com.aliexpress.es.tasks;

import com.aliexpress.es.interactions.CambioPestania;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.aliexpress.es.userInterfaces.InicioUI.TXT_BUSCADOR;
import static com.aliexpress.es.userInterfaces.ResultadoBusquedaUI.LBL_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProductoTask implements Task {
    private String producto;

    public BuscarProductoTask(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(producto).into(TXT_BUSCADOR).thenHit(Keys.ENTER),
                Check.whether(WebElementQuestion.stateOf(LBL_PRODUCTO.of(producto)), WebElementStateMatchers.isNotVisible())
                        .andIfSo(
                                WaitUntil.the(LBL_PRODUCTO.of(producto), isVisible()).forNoMoreThan(10).seconds()
                        ),
                Click.on(LBL_PRODUCTO.of(producto)),
                CambioPestania.cambioDePestania()
        );
    }

    public static BuscarProductoTask conElProducto(String producto) {
        return new BuscarProductoTask(producto);
    }
}