package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryPokemonTypeRepository implements PokemonTypeRepository {

    private final Map<String, List<PokeType>> pokemonTypes;
    private Integer calls = 0;

    public InMemoryPokemonTypeRepository(Map<String, List<PokeType>> pokemonTypes) {

        this.pokemonTypes = pokemonTypes;
    }

    @Override
    public List<PokeType> search(String pokeName) throws IOException {
        calls += 1;
        return pokemonTypes.get(pokeName);
    }

    public Integer calls() {
        return calls;
    }
}
