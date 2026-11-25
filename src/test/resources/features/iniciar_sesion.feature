Feature: Iniciar sesion

  @Login @HappyPath
  Scenario: Iniciar sesion de manera existosa
    Given el usuario esta en la pagina de inicio
    And ingresa el usuario "standard_user" y la contrasenia "secret_sauce"
    When selecciona el boton de login
    Then el titulo debe ser "Products"

  @Login @Negativo
  Scenario: Iniciar sesion con un usuario bloqueado
    Given el usuario esta en la pagina de inicio
    And ingresa el usuario "locked_out_user" y la contrasenia "secret_sauce"
    When selecciona el boton de login
    Then el mensaje debe ser "Epic sadface: Sorry, this user has been locked out."

  @Login @Negativo
  Scenario: Iniciar sesion sin completar los datos
    Given el usuario esta en la pagina de inicio
    When selecciona el boton de login
    Then el mensaje debe ser "Epic sadface: Username is required"
