Feature: Flight reservation
  To allow a user to make a flight reservation with web automation.
  Scenario: Reserve a flight in Blazedemo
    When I access "https://blazedemo.com"
    And I choose "Philadelphia" for departure
    And I choose "Cairo" for destination
    And I click find flights
    And the title should be Flights from "Philadelphia" to "Cairo":
    And I select flight
    And I check the reservation info
    And I fill the form
    Then I check purchase info