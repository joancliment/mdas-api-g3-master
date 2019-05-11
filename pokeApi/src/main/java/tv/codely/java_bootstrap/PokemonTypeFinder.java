package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinder {

    private final PokemonTypeRepository pokeApiRepository;
    private final PokemonTypeRepository cacheRepository;

    public PokemonTypeFinder(PokemonTypeRepository pokeApiRepository, PokemonTypeRepository cacheRepository) {
        this.pokeApiRepository = pokeApiRepository;
        this.cacheRepository = cacheRepository;
    }

    public List<PokeType> invoke(String pokemonName) throws IOException, PokeTypeException{
        List<PokeType> pokemonTypes;
        pokemonTypes = cacheRepository.search(pokemonName);
        if (pokemonTypes == null || pokemonTypes.size() == 0){
            pokemonTypes = pokeApiRepository.search(pokemonName);
            cacheRepository.save(pokemonName, pokemonTypes);
        }

        return pokemonTypes;

    }
}
