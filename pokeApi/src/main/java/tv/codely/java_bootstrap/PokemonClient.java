package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.io.IOException;

public class PokemonClient {

    public static void main(String[] args) throws IOException {

        PokemonTypeFinder pokeFinder = new PokemonTypeFinder();
        try {
            pokeFinder.poketypesFinder("bulbasaurr");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
