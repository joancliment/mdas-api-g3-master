package tv.codely.java_bootstrap.Shared.Application;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeFavsRepository;
import tv.codely.java_bootstrap.Pokemon.Domain.UserPokeFavs;

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
