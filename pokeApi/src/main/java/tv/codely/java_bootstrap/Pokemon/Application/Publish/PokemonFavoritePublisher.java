package tv.codely.java_bootstrap.Pokemon.Application.Publish;

import tv.codely.java_bootstrap.Shared.Domain.EventBus;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;
import tv.codely.java_bootstrap.Pokemon.Domain.UserID;
import tv.codely.java_bootstrap.Pokemon.Domain.UserPokeFavs;

public class PokemonFavoritePublisher {
    private final EventBus eventBus;

    public PokemonFavoritePublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(String user, String name) {
        final UserID userID = new UserID(user);
        final PokeName pokeName = new PokeName(name);

        final UserPokeFavs userPokeFavs = UserPokeFavs.publish(userID, pokeName);

        eventBus.publish(userPokeFavs.pullDomainEvents());
    }
}
