Feature: Verify Bored API

  Scenario: Verify API response code and schema
    Given the Bored API is accessible
    When I request an activity from the API
    Then the response code should be 200
    And the response should have the correct schema