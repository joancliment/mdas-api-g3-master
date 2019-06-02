package tv.codely.java_bootstrap.Pokemon.Application.Notification;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeFavsAdded;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;
import tv.codely.java_bootstrap.Pokemon.Domain.UserID;
import tv.codely.java_bootstrap.Pokemon.Domain.UserPokeFavs;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.InMemoryPokeFavsRepository;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.MemoryBD;
import tv.codely.java_bootstrap.Shared.Application.DomainEventSubscriber;
import tv.codely.java_bootstrap.Shared.Application.PokemonFavoriteAdder;

public class SendPushToSubscribersOnPokemonFavoritePublished implements DomainEventSubscriber<PokeFavsAdded> {
    @Override
    public Class<PokeFavsAdded> subscribedTo() {
        return PokeFavsAdded.class;
    }

    @Override
    public void consume(PokeFavsAdded event) {
        InMemoryPokeFavsRepository inMemoryPokeFavsRepository = new InMemoryPokeFavsRepository();
        MemoryBD memoryBd = MemoryBD.getInstance(inMemoryPokeFavsRepository);
        PokemonFavoriteAdder pokemonFavoriteAdder = new PokemonFavoriteAdder(memoryBd.pokeFavsRepository);
        pokemonFavoriteAdder.invoke(new UserPokeFavs(new PokeName(event.pokeName()), new UserID(event.userID())));

        System.out.println(
                String.format(
                        "Hey! There is a new pokemon favorite added with pokename <%s> and user <%s>",
                        event.pokeName(),
                        event.userID()
                )
        );
    }
}
