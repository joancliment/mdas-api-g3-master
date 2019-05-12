package tv.codely.java_bootstrap;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tv.codely.java_bootstrap.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

public class StepDefs {

    private String pokemonName;
    private PokeType pokeType;
    private SearchDto searchDto;
    private List<PokeType> actualPokemonFind;

    @Given("^i'm in CLI or Browser$")
    public void i_m_in_CLI_or_Browser() throws Throwable {

        PokemonTypeCLIController.main(new String[]{});

    }

    @When("^i enter pokemon name <pokemonName>$")
    public void i_enter_pokemon_name(String pokemonName) throws Throwable {

       System.out.println(pokemonName);
        /*
        this.pokemonName = searchDto.getPokemonTeclado();

        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
        PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository, pokeCachePokemonTypeRepository);
        actualPokemonFind = pokeFinder.invoke(this.pokemonName);
        */
    }

    @Then("^return the pokemon types$")
    public void ireturnTypes() {
        /*
        String actualPokemon = actualPokemonFind.get(0).getName();
        String expectedPokemom = this.pokeType.getName();

        assertEquals(expectedPokemom, actualPokemon);

         */
    }
}


