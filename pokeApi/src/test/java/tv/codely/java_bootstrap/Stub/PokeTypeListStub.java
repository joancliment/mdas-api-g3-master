package tv.codely.java_bootstrap.Stub;

import tv.codely.java_bootstrap.Shared.Domain.PokeType;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeList;

import java.util.ArrayList;
import java.util.List;

public class PokeTypeListStub {

    public static PokeTypeList create(List<PokeType> pokeTypes){
        return new PokeTypeList(pokeTypes);
    }

    public static PokeTypeList generateRandom() {

        String[] types = { "electric", "poison", "grass", "aquatic"};
        List<PokeType> randomTypeList = new ArrayList<>();
        String randomType;

        randomType = types[(int) (Math.floor(Math.random() * ((types.length ))))];
        randomTypeList.add(new PokeType(randomType));

        return new PokeTypeList(randomTypeList);
    }
}
