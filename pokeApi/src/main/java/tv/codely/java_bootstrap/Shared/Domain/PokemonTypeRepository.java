package tv.codely.java_bootstrap.Shared.Domain;

import tv.codely.java_bootstrap.Shared.Domain.PokeName;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeList;

import java.io.IOException;

public interface PokemonTypeRepository {

    PokeTypeList search(PokeName pokeName) throws IOException;
    void save(PokeName pokeName, PokeTypeList pokeTypes);
}
