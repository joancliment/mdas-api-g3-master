package tv.codely.java_bootstrap.Stub;

import tv.codely.java_bootstrap.Shared.Domain.PokeName;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeList;
import tv.codely.java_bootstrap.Shared.Domain.Pokemon;

public class PokemonStub {

    public static Pokemon create(PokeName pokeName, PokeTypeList pokeTypes) {
        return new Pokemon(pokeName,pokeTypes);
    }
}
