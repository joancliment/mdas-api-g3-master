package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class ThrowsIOExceptionPokemonTypeRepository implements PokemonTypeRepository {

    @Override
    public List<PokeType> search(String pokeName) throws IOException {
        throw new IOException("Timeout");

    }

}
