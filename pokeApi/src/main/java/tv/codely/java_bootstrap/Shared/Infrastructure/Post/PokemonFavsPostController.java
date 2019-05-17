package tv.codely.java_bootstrap.Shared.Infrastructure.Post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.java_bootstrap.Shared.Application.PokemonFavoriteAdder;
import tv.codely.java_bootstrap.Shared.Domain.PokeName;
import tv.codely.java_bootstrap.Shared.Domain.PokeTypeException;
import tv.codely.java_bootstrap.Shared.Domain.UserID;
import tv.codely.java_bootstrap.Shared.Domain.UserPokeFavs;
import tv.codely.java_bootstrap.Shared.Infrastructure.InMemoryPokeFavsRepository;
import tv.codely.java_bootstrap.Shared.Infrastructure.MemoryBD;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PokemonFavsPostController {

    @RequestMapping("/help")
    public String index()
    {
        return "Try this: http://localhost:8080/addFavorite?name=pikachu?user=8";
    }


    @RequestMapping(value = "/addFavorite", method=POST)
    public String addFavorite(@RequestParam(value="name") String name, @RequestParam(value="user") String user) throws IOException, PokeTypeException {
        String result;
        InMemoryPokeFavsRepository inMemoryPokeFavsRepository = new InMemoryPokeFavsRepository();
        MemoryBD memoryBd = MemoryBD.getInstance(inMemoryPokeFavsRepository);
        PokemonFavoriteAdder pokemonFavoriteAdder = new PokemonFavoriteAdder(memoryBd.pokeFavsRepository);
        result = pokemonFavoriteAdder.invoke(new UserPokeFavs(new PokeName(name), new UserID(user)));
        return result;
    }
}
