package com.aliexpress.es.stepDefinitions;

import com.aliexpress.es.questions.*;
import io.cucumber.java.Before;
import com.aliexpress.es.tasks.*;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.math.BigDecimal;

import static com.aliexpress.es.userInterfaces.ProductoUI.TXT_PRECIO_UNIDAD;
import static com.aliexpress.es.utils.Utils.obtenerPrecio;
import static net.serenitybdd.screenplay.actors.OnStage.*;

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

        theActorInTheSpotlight().attemptsTo(
                BuscarProductoTask.conElProducto(producto)
        );
    }

    @Cuando("agrega la cantidad de {int} veces el producto al carrito")
    public void agregaLaCantidadDeVecesElProductoAlCarrito(Integer cantidadProducto) {

        theActorInTheSpotlight().attemptsTo(
                AgregarProductoCarritoTask.conCantidadProducto(cantidadProducto)
        );
    }

    @Entonces("el producto {string} debe visualizarse en el carrito con su precio total")
    public void elProductoDebeVisualizarseEnElCarritoConSuPrecioTotal(String producto) {

        BigDecimal precioUnidad = obtenerPrecio(TXT_PRECIO_UNIDAD.resolveFor(theActorInTheSpotlight()).getText());

        theActorInTheSpotlight().attemptsTo(
                CarritoComprasTask.con()
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidarProductoCarrito.value(producto)),
                GivenWhenThen.seeThat(ValidarPrecioCarrito.value(precioUnidad))
        );
    }
}
