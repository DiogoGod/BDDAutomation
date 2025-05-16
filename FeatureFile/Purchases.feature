Feature: User buys items

  Scenario Outline:adding two items to the cart and validate total
    Given User is on login page
    When  User enters username
    And   User enters password
    And  User clicks on login button
    Then User should be loggedin
    And User adds two products to cart "<firstProduct>" "<secondProduct>"
    And User clicks on shopping cart
    And User clicks checkout
    And User fills the information with firstName "<firstName>", lastName "<lastName>" and ZipCode "<zipCode>"
    Then Verify if the total price is correct
    Examples:
    |firstProduct| secondProduct|firstName|lastName|zipCode|
    |add-to-cart-sauce-labs-backpack|add-to-cart-sauce-labs-bike-light|Diogo|Godinho|7100-151|

    Scenario Outline:Remove an item from the cart and verify it
      Given User is on login page
      When  User enters username
      And   User enters password
      And  User clicks on login button
      Then User should be loggedin
      And User adds a product "<product>" to the cart
      And User clicks on shopping cart
      And User removes product "<product2>" from the cart
      Then verify if product "<product2>" is removed
      Examples:
      |product|product2|
      |add-to-cart-sauce-labs-backpack|remove-sauce-labs-backpack|

     Scenario Outline: Complete a purchase
       Given User is on login page
       When  User enters username
       And   User enters password
       And  User clicks on login button
       Then User should be loggedin
       And User adds a product "<product>" to the cart
       And User clicks on shopping cart
       And User clicks checkout
       And User fills the information with firstName "<firstName>", lastName "<lastName>" and ZipCode "<zipCode>"
       Then User clicks on finish button
       Examples:
         |product|firstName|lastName|zipCode|
         |add-to-cart-sauce-labs-backpack|Diogo|Godinho|7100-151|
