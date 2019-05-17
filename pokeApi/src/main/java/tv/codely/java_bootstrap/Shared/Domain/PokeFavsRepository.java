package tv.codely.java_bootstrap.Shared.Domain;

public interface PokeFavsRepository {
    void add (UserPokeFavs userPokeFavs);
    int countFavorites(PokeName pokeName);
}
