package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PokemonTypeRepository {

    List<PokeType> search(String pokeName) throws IOException;
    void save(String pokeName, List<PokeType> types);
}
