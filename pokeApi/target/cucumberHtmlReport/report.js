$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/PokemonTypeSearch");
formatter.feature({
  "line": 1,
  "name": "Search Pokemon Type",
  "description": "",
  "id": "search-pokemon-type",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search pokemon types by pokemon name",
  "description": "",
  "id": "search-pokemon-type;search-pokemon-types-by-pokemon-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "i\u0027m in CLI or Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "i enter pokemon name \u003cpokemonName\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "return the pokemon types",
  "rows": [
    {
      "cells": [
        "pokemonName"
      ],
      "line": 7
    },
    {
      "cells": [
        "pikachu"
      ],
      "line": 8
    }
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});