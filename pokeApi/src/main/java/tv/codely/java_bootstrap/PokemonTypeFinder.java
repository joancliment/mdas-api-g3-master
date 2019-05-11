package tv.codely.java_bootstrap;

import java.io.IOException;

public class PokemonTypeFinder {

    private final PokemonTypeRepository pokeApiRepository;
    private final PokemonTypeRepository cacheRepository;

    public PokemonTypeFinder(PokemonTypeRepository pokeApiRepository, PokemonTypeRepository cacheRepository) {
        this.pokeApiRepository = pokeApiRepository;
        this.cacheRepository = cacheRepository;
    }

    public PokeTypeList invoke(PokeName pokemonName) throws IOException, PokeTypeException{
        PokeTypeList pokemonTypes;
        try {
            pokemonTypes = cacheRepository.search(pokemonName);
        }
        catch (PokeTypeException e){
            pokemonTypes = pokeApiRepository.search(pokemonName);
            cacheRepository.save(pokemonName, pokemonTypes);

        }

        return pokemonTypes;

    }
}
