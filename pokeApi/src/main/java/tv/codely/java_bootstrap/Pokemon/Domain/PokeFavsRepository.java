package tv.codely.java_bootstrap.Pokemon.Domain;

public interface PokeFavsRepository {
    void add (UserPokeFavs userPokeFavs);
    TotalPokeFavs countFavorites(PokeName pokeName);
}
