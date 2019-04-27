package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.util.List;

public class PokemonClient {

    String pokename = "Charmander";

    public static void main(String[] args) {
        PokeApi pokeApi = new PokeApiClient();
        Pokemon pokemon = pokeApi.getPokemon(1);
        final List<PokemonType> types = pokemon.getTypes();
        types.forEach((p) -> {System.out.println(p.getType().getName());});
    }


}
