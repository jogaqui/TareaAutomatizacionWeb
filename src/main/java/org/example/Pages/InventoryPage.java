package org.example.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target BTN_ADD_BACKPACK = Target.the("Agregar mochila")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target BTN_REMOVE_BACKPACK = Target.the("Quitar mochila")
            .located(By.id("remove-sauce-labs-backpack"));

    public static final Target LBL_CARRITO = Target.the("Cantidad del carrito")
            .located(By.cssSelector(".shopping_cart_badge"));

    public static final Target BTN_CARRITO = Target.the("Icono del carrito")
            .located(By.className("shopping_cart_link"));

    public static final Target LBL_PRODUCTO = Target.the("Nombre del producto")
            .located(By.className("inventory_item_name"));

    public static final Target SELECT_ORDEN = Target.the("Orden de productos")
            .located(By.cssSelector("[data-test='product-sort-container']"));
}
