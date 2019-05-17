package tv.codely.java_bootstrap.Shared.Infrastructure.CLI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tv.codely.java_bootstrap.Shared.Domain.PokeName;
import tv.codely.java_bootstrap.Stub.PokeNameStub;

import java.io.IOException;

public class CLIStepDefs {
    Process proc;

    @Given("^i'm in CLI$")
    public void i_m_in_CLI() throws Throwable {
        //en mac ("/bin/bash", "-c", ...
        //en win ("cmd.exe", "/c", ...
        String[] args = new String[] {"cmd.exe", "/c",
                "java src/main/java/tv.codely.java_bootstrap/PokemonTypeCLIController", "", ""};
        proc = new ProcessBuilder(args).start();
    }

    @When("^i enter pokemon name <pokemonName>$")
    public void i_enter_pokemon_name() throws Throwable {
        PokeName pokeName = PokeNameStub.generateRandom();
        proc.getOutputStream().write(pokeName.get().getBytes());
       System.out.println(pokeName.get());
    }

    @Then("^return the pokemon types$")
    public void ireturnTypes() {
        try{
            int w = proc.getInputStream().read();
            System.out.println(w);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        /* String actualPokemon = actualPokemonFind.get(0).getName();
        String expectedPokemom = this.pokeType.getName();
        assertEquals(expectedPokemom, actualPokemon);*/
    }
}


