package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinder {

    private final PokemonTypeRepository pokemonTypeRepository;
    private final PokemonTypeRepository cacheRepository;

    public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository, PokemonTypeRepository cacheRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.cacheRepository = cacheRepository;
    }

    public List<PokeType> invoke(String pokemonName) throws IOException, PokeTypeException{
        List<PokeType> pokemonTypes;
        pokemonTypes = cacheRepository.search(pokemonName);
        if (pokemonTypes.size() == 0){
            pokemonTypes = pokemonTypeRepository.search(pokemonName);
        }
        pokemonTypes.forEach((t) -> {t.getName();});
        cacheRepository.save(pokemonName, pokemonTypes);
        return pokemonTypes;

    }
}
