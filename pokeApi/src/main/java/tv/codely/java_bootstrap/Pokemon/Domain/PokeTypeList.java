package tv.codely.java_bootstrap.Pokemon.Domain;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeType;

import java.util.List;

public class PokeTypeList {

    private List<PokeType> pokeTypeList;

    public List<PokeType> get() {
        return pokeTypeList;
    }

    public PokeTypeList(List<PokeType> pokeTypeList) {
        this.pokeTypeList = pokeTypeList;
    }


}
