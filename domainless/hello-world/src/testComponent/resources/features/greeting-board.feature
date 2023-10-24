Feature: getting a greeting board
  Greeting board is a board that contains greetings in different languages, and a joke as a bonus.

  Scenario: Getting a board
    When Call to GET /board is made
    Then The response must contain 4 greetings
    And "Which planet loves to sing? Nep-tune!" must be a bonus joke
