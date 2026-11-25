package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.InventoryPage;
import org.example.Questions.ResponseCode;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class Catalogo {

    @When("agrega la mochila al carrito")
    public void agregaLaMochilaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(InventoryPage.BTN_ADD_BACKPACK, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(InventoryPage.BTN_ADD_BACKPACK),
                WaitUntil.the(InventoryPage.BTN_REMOVE_BACKPACK, isVisible()).forNoMoreThan(10).seconds()
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 4 mochila agregada");
    }

    @Then("el carrito debe tener {string} producto")
    public void elCarritoDebeTenerProducto(String cantidad) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(InventoryPage.LBL_CARRITO, isVisible()).forNoMoreThan(10).seconds()
        );
        theActorInTheSpotlight().should(seeThat(ResponseCode.textoDe(InventoryPage.LBL_CARRITO), equalTo(cantidad)));
    }

    @And("el carrito muestra {string}")
    public void elCarritoMuestra(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(InventoryPage.BTN_CARRITO),
                WaitUntil.the(InventoryPage.LBL_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 5 carrito");
        theActorInTheSpotlight().should(seeThat(ResponseCode.textoDe(InventoryPage.LBL_PRODUCTO), equalTo(nombre)));
    }

    @When("ordena los productos por {string}")
    public void ordenaLosProductosPor(String criterio) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(InventoryPage.SELECT_ORDEN, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(criterio).from(InventoryPage.SELECT_ORDEN)
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 4 productos ordenados");
    }

    @Then("el primer producto debe ser {string}")
    public void elPrimerProductoDebeSer(String nombre) {
        theActorInTheSpotlight().should(
                seeThat(ResponseCode.textoDe(InventoryPage.LBL_PRODUCTO), equalTo(nombre))
        );
    }
}
