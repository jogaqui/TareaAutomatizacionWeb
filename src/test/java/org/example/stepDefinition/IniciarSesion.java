package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.HomePage;
import org.example.Questions.ResponseCode;
import org.example.Tasks.NagivateHome;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class IniciarSesion {

    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(
                NagivateHome.theHomePage(),
                WaitUntil.the(HomePage.INP_USERNAME, isVisible()).forNoMoreThan(10).seconds()
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 0 pagina de inicio");
    }

    @And("ingresa el usuario {string} y la contrasenia {string}")
    public void ingresaElUsuarioYLaContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(username).into(HomePage.INP_USERNAME),
                Enter.theValue(password).into(HomePage.INP_PASSWORD)
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 1 datos ingresados");
    }

    @When("selecciona el boton de login")
    public void seleccionaElBotonDeLogin() {
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 2 antes de login");
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN));
    }

    @Then("el titulo debe ser {string}")
    public void elTituloDebeSer(String titulo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.LBL_TITULO, isVisible()).forNoMoreThan(10).seconds()
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 3 login existoso");
        theActorInTheSpotlight().should(seeThat(ResponseCode.textoDe(HomePage.LBL_TITULO), equalTo(titulo)));
    }

    @Then("el mensaje debe ser {string}")
    public void elMensajeDebeSer(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.LBL_ERROR, isVisible()).forNoMoreThan(10).seconds()
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Sesion 3 mensaje de error");
        theActorInTheSpotlight().should(seeThat(ResponseCode.textoDe(HomePage.LBL_ERROR), equalTo(mensaje)));
    }
}
