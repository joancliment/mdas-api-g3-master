package tv.codely.java_bootstrap.Acceptance;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tv.codely.java_bootstrap.PokeName;
import tv.codely.java_bootstrap.Stub.PokeNameStub;

import java.io.IOException;

public class GetStepDefs {
    Process proc;

    @Given("^i'm in CLI or Browser$")
    public void i_m_in_or_Browser() throws Throwable {
        //en mac ("/bin/bash", "-c", ...
        //en win ("cmd.exe", "/c", ...
        String[] args = new String[] {"cmd.exe", "/c", "java PokemonTypeCLIController", "", ""};
        proc = new ProcessBuilder(args).start();
    }

    @When("^i enter pokemon name <pokemonName>$")
    public void i_enter_pokemon_name2() throws Throwable {
        PokeName pokeName = PokeNameStub.generateRandom();
        proc.getOutputStream().write(pokeName.getPokeName().getBytes());
       System.out.println(pokeName.getPokeName());
    }

    @Then("^return the pokemon types$")
    public void ireturnTypes2(DataTable arg1) {
        try{
            int w = proc.getInputStream().read();
            System.out.println(w);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        /* String actualPokemon = actualPokemonFind.get(0).getName();
        String expectedPokemom = this.pokeType.getName();
        assertEquals(expectedPokemom, actualPokemon);*/
        System.out.println(arg1);
    }
}


