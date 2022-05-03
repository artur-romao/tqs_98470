Feature: Covid metrics
  To allow a user to check world and specific country statistics with web automation.
  Scenario: Check Covid-19 statistics
    When I access "http://localhost:8080/"
    And I click on "Worldwide Statistics" and check world statistics
    And I click on "Country Statistics" and observe a page to Select a country
    Then I choose "Portugal" to check it's statistics