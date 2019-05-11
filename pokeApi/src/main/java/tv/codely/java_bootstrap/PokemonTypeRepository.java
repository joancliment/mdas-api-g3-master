package tv.codely.java_bootstrap;

import java.io.IOException;

public interface PokemonTypeRepository {

    PokeTypeList search(PokeName pokeName) throws IOException;
    void save(PokeName pokeName, PokeTypeList pokeTypes);
}
