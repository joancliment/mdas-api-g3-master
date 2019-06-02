package tv.codely.java_bootstrap.Pokemon.Infrastructure;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeFavsRepository;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;
import tv.codely.java_bootstrap.Pokemon.Domain.TotalPokeFavs;
import tv.codely.java_bootstrap.Pokemon.Domain.UserPokeFavs;

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


