package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public interface PokemonTypeRepository {

    List<PokeType> search(String pokeName) throws IOException;
}
