package tv.codely.java_bootstrap.Pokemon.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Pokemon {

    PokeName pokeName;
    PokeTypeList pokeTypes;
    TotalPokeFavs totalPokeFavs;

    public PokeName getPokeName() {
        return pokeName;
    }

    public PokeTypeList getPokeTypes() {
        return pokeTypes;
    }

    public TotalPokeFavs getTotalPokeFavs() {
        return totalPokeFavs;
    }

    public Pokemon(PokeName pokeName, PokeTypeList pokeTypeList) {
        this.pokeName = pokeName;
        this.pokeTypes = pokeTypeList;
    }

    public Pokemon(PokeName pokeName, PokeTypeList pokeTypeList, TotalPokeFavs totalPokeFavs) {
        this.pokeName = pokeName;
        this.pokeTypes = pokeTypeList;
        this.totalPokeFavs = totalPokeFavs;
    }

}
