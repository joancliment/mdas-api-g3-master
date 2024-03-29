package tv.codely.java_bootstrap.Pokemon.Infrastructure;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeTypeException;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeTypeList;
import tv.codely.java_bootstrap.Pokemon.Domain.PokemonTypeRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PokeCachePokemonTypeRepository implements PokemonTypeRepository {

    Map<PokeName, PokeTypeList> pokeCache = new HashMap<>();

    @Override
    public PokeTypeList search(PokeName pokeName) throws IOException {
        PokeTypeList pokeType = pokeCache.get(pokeName);
        if(pokeType == null){
            throw new PokeTypeException();
        }
        return pokeType;
    }

    @Override
    public void save(PokeName pokeName, PokeTypeList pokeTypes) {

        pokeCache.put(pokeName, pokeTypes);
    }
}
