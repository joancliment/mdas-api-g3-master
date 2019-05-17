package tv.codely.java_bootstrap.Shared.Infrastructure.Get;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.java_bootstrap.Shared.Application.PokemonTypeFinder;
import tv.codely.java_bootstrap.Shared.Domain.*;
import tv.codely.java_bootstrap.Shared.Infrastructure.InMemoryPokeFavsRepository;
import tv.codely.java_bootstrap.Shared.Infrastructure.PokeApiPokemonTypeRepository;
import tv.codely.java_bootstrap.Shared.Infrastructure.PokeCachePokemonTypeRepository;
import tv.codely.java_bootstrap.Shared.Application.PokemonFavoriteAdder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PokemonTypeGetController {

    @RequestMapping("/")
    public String index()
    {
        return "Try this: http://localhost:8080/types?name=pikachu";
    }

    @RequestMapping(value = "/types", method=GET)
    public List<PokeType> getType(@RequestParam(value="name") String name) throws IOException, PokeTypeException {
        PokeTypeList pokeList;
        PokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeRepository pokeCachePokemonTypeRepo = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepo);
        pokeList = pokemonTypeFinderApi.invoke(new PokeName(name));
        return pokeList.get();
    }
}