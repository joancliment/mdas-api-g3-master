package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.util.List;

public class CLIProtocol {

    public List<PokemonType> getPokeTypeById (int id){
        PokeApi pokeApi = new PokeApiClient();
        Pokemon pokemon = pokeApi.getPokemon(1);
        final List<PokemonType> types = pokemon.getTypes();
        return types;
    }

}
