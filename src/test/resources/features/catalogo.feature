Feature: Catalogo de productos

  @Catalogo
  Scenario: Agregar un producto al carrito
    Given el usuario esta en la pagina de inicio
    And ingresa el usuario "standard_user" y la contrasenia "secret_sauce"
    And selecciona el boton de login
    When agrega la mochila al carrito
    Then el carrito debe tener "1" producto
    And el carrito muestra "Sauce Labs Backpack"

  @Catalogo
  Scenario: Ordenar los productos de menor a mayor precio
    Given el usuario esta en la pagina de inicio
    And ingresa el usuario "standard_user" y la contrasenia "secret_sauce"
    And selecciona el boton de login
    When ordena los productos por "Price (low to high)"
    Then el primer producto debe ser "Sauce Labs Onesie"
