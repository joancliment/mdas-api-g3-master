package tv.codely.java_bootstrap.Pokemon.Infrastructure.Get;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.java_bootstrap.Pokemon.Domain.*;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.InMemoryPokeFavsRepository;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.MemoryBD;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.PokeApiPokemonTypeRepository;
import tv.codely.java_bootstrap.Pokemon.Infrastructure.PokeCachePokemonTypeRepository;
import tv.codely.java_bootstrap.Shared.Application.PokemonTypeFinder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PokemonTypeGetController {

    @RequestMapping("/")
    public String index() {
        return "Try this: http://localhost:8080/types?name=pikachu";
    }

    @RequestMapping(value = "/types", method = GET)
    public List<PokeType> getType(@RequestParam(value = "name") String name) throws IOException, PokeTypeException {
        PokeTypeList pokeList;
        PokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeRepository pokeCachePokemonTypeRepo = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepo);
        pokeList = pokemonTypeFinderApi.invoke(new PokeName(name));
        return pokeList.get();
    }


    @RequestMapping(value = "/pokemon", method = GET)
    public String getPokemon(@RequestParam(value = "name") String name) throws IOException, PokeTypeException {
        PokeTypeList pokeList;
        PokeName pokeName = new PokeName(name);
        PokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeRepository pokeCachePokemonTypeRepo = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepo);
        pokeList = pokemonTypeFinderApi.invoke(pokeName);

        InMemoryPokeFavsRepository inMemoryPokeFavsRepository = new InMemoryPokeFavsRepository();
        MemoryBD memoryBD = MemoryBD.getInstance(inMemoryPokeFavsRepository);
        TotalPokeFavs favorites = memoryBD.pokeFavsRepository.countFavorites(pokeName);

        Pokemon pokemon = new Pokemon(pokeName, pokeList, favorites);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String s = "";
        try{
            s = mapper.writeValueAsString(pokemon);
            System.out.println(s);
        }
        catch (Exception e){
            e.getMessage();
        }
        return s;
    }
}
