package tv.codely.java_bootstrap.Shared.Domain;

public class Pokemon {
    PokeName pokeName;
    PokeTypeList pokeTypes;

    public Pokemon(PokeName pokeName, PokeTypeList pokeTypeList) {
        this.pokeName = pokeName;
        this.pokeTypes = pokeTypeList;
    }

}
