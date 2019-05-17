package tv.codely.java_bootstrap.Shared.Infrastructure;

import tv.codely.java_bootstrap.Shared.Domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPokeFavsRepository implements PokeFavsRepository {

    List<UserPokeFavs> pokeFavs = new ArrayList<>();

    @Override
    public void add(UserPokeFavs userPokeFavs) {
        if(!pokeFavs.contains(userPokeFavs))
            pokeFavs.add(userPokeFavs);
    }

    @Override
    public int countFavorites(PokeName pokeName) {
        return 0;
    }

}
