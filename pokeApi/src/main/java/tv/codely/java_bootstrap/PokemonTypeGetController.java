package tv.codely.java_bootstrap;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PokemonTypeGetController {

    @RequestMapping("/")
    public String index()
    {
        return "Try this: http://localhost:8080/types?name=pikachu";
    }

    @RequestMapping(value = "/types", method=GET)
    public List<PokeType> getType(@RequestParam(value="name") String name) {
        PokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeRepository pokeCachePokemonTypeRepo = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepo);
        try {
            PokeTypeList pokeList = pokemonTypeFinderApi.invoke(new PokeName(name));
            return pokeList.get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (PokeTypeException pe){
            pe.getMessage();
            return null;
        }
    }
}