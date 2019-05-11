package tv.codely.java_bootstrap.Stub;

import tv.codely.java_bootstrap.PokeName;
import tv.codely.java_bootstrap.PokeTypeList;
import tv.codely.java_bootstrap.Pokemon;

public class PokemonStub {

    public static Pokemon create(PokeName pokeName, PokeTypeList pokeTypes) {
        return new Pokemon(pokeName,pokeTypes);
    }
}
