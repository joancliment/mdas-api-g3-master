Feature: Search Pokemon Type

  Scenario: Search pokemon types by pokemon name
    Given i'm in Browser
    When i enter pokemon name <pokemonName>
    Then return the pokemon types