package tv.codely.java_bootstrap.Shared.Domain;

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
