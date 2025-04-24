package com.aliexpress.es.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class CambioPestania implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String ventanaActual = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(ventanaActual)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static CambioPestania cambioDePestania() {
        return new CambioPestania();
    }
}