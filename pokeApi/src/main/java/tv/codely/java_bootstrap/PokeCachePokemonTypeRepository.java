package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokeCachePokemonTypeRepository implements PokemonTypeRepository{

    Map<String, List<PokeType>> pokeCache = new HashMap<>();

    @Override
    public List<PokeType> search(String pokeName) throws IOException {
       return pokeCache.get(pokeName);
    }

    @Override
    public void save(String pokeName, List<PokeType> types) {
        pokeCache.put(pokeName, types);
    }
}
