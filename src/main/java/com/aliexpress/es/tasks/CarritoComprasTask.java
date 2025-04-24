package com.aliexpress.es.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.aliexpress.es.userInterfaces.ProductoUI.BTN_CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CarritoComprasTask implements Task {
    public CarritoComprasTask() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(WebElementQuestion.stateOf(BTN_CARRITO), WebElementStateMatchers.isNotVisible())
                        .andIfSo(
                                WaitUntil.the(BTN_CARRITO, isVisible()).forNoMoreThan(10).seconds()
                        ),
                Click.on(BTN_CARRITO)
        );
    }

    public static CarritoComprasTask con() {
        return new CarritoComprasTask();
    }
}