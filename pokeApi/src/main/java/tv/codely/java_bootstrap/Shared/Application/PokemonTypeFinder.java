package tv.codely.java_bootstrap.Shared.Application;

import tv.codely.java_bootstrap.Shared.Domain.PokeName;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeException;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeList;
import tv.codely.java_bootstrap.Shared.Domain.PokemonTypeRepository;

import java.io.IOException;

public class PokemonTypeFinder {

    private final PokemonTypeRepository pokeApiRepository;
    private final PokemonTypeRepository cacheRepository;

    public PokemonTypeFinder(PokemonTypeRepository pokeApiRepository, PokemonTypeRepository cacheRepository) {
        this.pokeApiRepository = pokeApiRepository;
        this.cacheRepository = cacheRepository;
    }

    public PokeTypeList invoke(PokeName pokemonName) throws IOException, PokeTypeException {
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
