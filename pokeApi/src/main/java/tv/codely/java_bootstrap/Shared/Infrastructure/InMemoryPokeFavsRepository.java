package tv.codely.java_bootstrap.Shared.Infrastructure;

import tv.codely.java_bootstrap.Shared.Domain.*;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPokeFavsRepository implements PokeFavsRepository {

    List<UserPokeFavs> pokeFavs = new ArrayList<>();

    @Override
    public void add(UserPokeFavs userPokeFavs) {
        if(!pokeFavs.contains(userPokeFavs))
            pokeFavs.add(userPokeFavs);
    }

    @Override
    public TotalPokeFavs countFavorites(PokeName pokeName) {
        final TotalPokeFavs totalFavs = new TotalPokeFavs(0);
        pokeFavs.forEach(p->{
            if(p.getPokeName().get().equals(pokeName.get()))
                 totalFavs.increase();
        });
        return totalFavs;
    }

}


