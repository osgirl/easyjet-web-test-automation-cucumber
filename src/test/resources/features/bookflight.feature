Feature: Book a flight

  Scenario Outline: Book a one-way flight
    Given I am on home page
    When I searh for one-way flight from <from> to <to> on <departureDate>
    And  choose an available flight
    And proceed to checkout
    And skip seat selection
    And skip luggage selection
    And skip hotel selection
    And skip car-hire selection
    And continue with new-user create-account
    And add booker's details
    And add passenger's details
    Then basket details should match
    Examples:
      | from          | to       | departureDate |
      | Luton         | Alicante | anyFutureDate |









