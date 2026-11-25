package org.example.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class HomePage extends PageObject {

    public static final Target INP_USERNAME = Target.the("Usuario")
            .located(By.id("user-name"));

    public static final Target INP_PASSWORD = Target.the("Contraseña")
            .located(By.id("password"));

    public static final Target BTN_LOGIN = Target.the("Boton Login")
            .located(By.id("login-button"));

    public static final Target LBL_ERROR = Target.the("Mensaje de error")
            .located(By.cssSelector("h3[data-test='error']"));

    public static final Target LBL_TITULO = Target.the("Titulo de la pagina")
            .located(By.cssSelector(".title"));
}
