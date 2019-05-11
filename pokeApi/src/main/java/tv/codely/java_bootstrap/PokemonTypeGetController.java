package tv.codely.java_bootstrap;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PokemonTypeGetController {

    @RequestMapping(value = "/types", method=GET)
    public PokeTypeList getType(@RequestParam(value="name") String name) {
        PokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeRepository pokeCachePokemonTypeRepo = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepo);
        try {
            return pokemonTypeFinderApi.invoke(new PokeName(name));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (PokeTypeException pe){
            pe.getMessage();
            return null;
        }
    }
}