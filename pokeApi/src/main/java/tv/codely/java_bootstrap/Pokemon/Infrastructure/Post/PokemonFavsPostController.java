package tv.codely.java_bootstrap.Pokemon.Infrastructure.Post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.java_bootstrap.Pokemon.Domain.PokeTypeException;
import tv.codely.java_bootstrap.Shared.Application.DomainEventSubscriber;
import tv.codely.java_bootstrap.Pokemon.Application.Publish.PokemonFavoritePublisher;
import tv.codely.java_bootstrap.Pokemon.Application.Notification.SendPushToSubscribersOnPokemonFavoritePublished;
import tv.codely.java_bootstrap.Shared.Domain.*;
import tv.codely.java_bootstrap.Shared.Infrastructure.ReactorEventBus;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PokemonFavsPostController {

    final Set<DomainEventSubscriber> subscribers = new HashSet<>(Arrays.asList((new SendPushToSubscribersOnPokemonFavoritePublished())));

    final EventBus eventBus = new ReactorEventBus(subscribers);

    @RequestMapping("/help")
    public String index()
    {
        return "Try this: http://localhost:8080/addFavorite?name=pikachu?user=8";
    }


    @RequestMapping(value = "/addFavorite", method=POST)
    public String addFavorite(@RequestParam(value="name") String name, @RequestParam(value="user") String user) throws IOException, PokeTypeException {
        String result = "Pokemon Added";
        final PokemonFavoritePublisher pokemonFavoritePublisher = new PokemonFavoritePublisher(eventBus);
        pokemonFavoritePublisher.publish(user, name);

        return result;
    }
}
