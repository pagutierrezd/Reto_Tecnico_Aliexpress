package com.aliexpress.es.stepDefinitions;

import io.cucumber.java.Before;
import com.aliexpress.es.tasks.*;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class AgregarProductoStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentra en la pagina {string}")
    public void queElUsuarioSeEncuentraEnLaPagina(String url) {
        WebDriverManager.chromedriver().setup();
        theActorCalled("Robot").wasAbleTo(Open.url(url));
    }
    @Cuando("busca un producto {string}")
    public void buscaUnProducto(String producto) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarProductoTask.conElProducto(producto)
        );
    }
    @Cuando("agrega la cantidad de {int} veces el producto al carrito")
    public void agregaLaCantidadDeVecesElProductoAlCarrito(Integer cantidadProducto) {
    }
    @Entonces("el producto {string} debe visualizarse en el carrito con su precio total")
    public void elProductoDebeVisualizarseEnElCarritoConSuPrecioTotal(String producto) {
    }
}
