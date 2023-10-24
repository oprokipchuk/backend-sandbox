Feature: base request to check liveness
  This request is mainly used to check if the service is working.
  If the app is running, it must return a successful response.

  Scenario: Calling liveness path
    When Call to GET / is made
    Then The response status code must be 200
    And "Hello World!" text must be returned
