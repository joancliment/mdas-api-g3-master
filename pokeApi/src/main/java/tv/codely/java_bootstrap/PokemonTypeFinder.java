package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinder {

    private final PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public List<PokeType> invoke(String pokemonName) throws IOException, PokeTypeException{
        List<PokeType> pokemonTypes = pokemonTypeRepository.search(pokemonName);
        pokemonTypes.forEach((t) -> {t.getName();});

        return pokemonTypes;

    }
}
