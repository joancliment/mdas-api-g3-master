package tv.codely.java_bootstrap.Pokemon.Infrastructure.CLI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeTypeList;
import tv.codely.java_bootstrap.Stub.PokeNameStub;
import tv.codely.java_bootstrap.Stub.PokeTypeListStub;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;

public class CLIStepDefs {
    Process proc;
    Process pr;
    BufferedReader reader;
    BufferedWriter writer;
    Scanner scanner;
    InputStream stdout;
    OutputStream stdin;
    PokeName pokeName;

    @Given("^i'm in CLI$")
    public void i_m_in_CLI() throws Throwable {
        //en mac ("/bin/bash", "-c", ...
        //en win ("cmd.exe", "/c", ...
        //String[] args = new String[] {"bash", "-c", "ls -la"};
        //String[] args = new String[] {"bash", "-c", "java src/main/java/tv/codely/java_bootstrap/Pokemon/Infrastructure/CLI/PokemonTypeCLIController"};

        ProcessBuilder proc = new ProcessBuilder();
        proc.command("bash", "-c", "java src/main/java/tv/codely/java_bootstrap/Pokemon/Infrastructure/CLI/PokemonTypeCLIController");
        pr = proc.start();
        stdin = pr.getOutputStream();
        stdout = pr.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stdout));
        writer = new BufferedWriter(new OutputStreamWriter(stdin));
        scanner = new Scanner(stdout);

    }

    @When("^i enter pokemon name <pokemonName>$")
    public void i_enter_pokemon_name() throws Throwable {
        pokeName = PokeNameStub.generateRandom();
        writer.write(pokeName.get()+"\n");
        writer.flush();
        writer.close();
    }

    @Then("^return the pokemon types$")
    public void ireturnTypes() throws IOException {
        String actual = PokeTypeListStub.generateRandom().get().get(0).getName();
        scanner = new Scanner(stdout);
        if(scanner.hasNextLine())
            actual = scanner.nextLine();
        assertThat(actual, !actual.isEmpty());
    }
}


