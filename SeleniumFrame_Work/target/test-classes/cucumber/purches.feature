
@tag
Feature: Purchase order from ECom page
  I want to use this template for my feature file

Background:
Given: landed to the ECom Page
  
  @tag2
  Scenario Outline: Postivite Test Case for Submitting the order
    Given login to the ECom page by using username <name> and password <password>
    When Checkout the product <productname> to the Cart
    And checkout <productname> and submit the order
    Then Verify the "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

    Examples: 
      | name              | password      | productname     | 
      | prajna@gmail.com  | Lipa@0811     | ADIDAS ORIGINAL | 
                                                 
