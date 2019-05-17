package tv.codely.java_bootstrap.Shared.Application;

import tv.codely.java_bootstrap.Shared.Domain.*;
import tv.codely.java_bootstrap.Shared.Infrastructure.InMemoryPokeFavsRepository;

import java.io.IOException;

public class PokemonFavoriteAdder {

    private final PokeFavsRepository pokeFavsRepository;

    public PokemonFavoriteAdder(PokeFavsRepository cacheRepository) {
        this.pokeFavsRepository = cacheRepository;
    }

    public String invoke(UserPokeFavs userPokeFavs) {
        pokeFavsRepository.add(userPokeFavs);
        return "Pokemon añadido!";

    }
}
