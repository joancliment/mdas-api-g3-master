package tv.codely.java_bootstrap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PokemonTypeGetController {

    @RequestMapping(value = "/types", method=GET)
    public List<PokeType> getType(@RequestParam(value="name") String name) {
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
        PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinderApi = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
        PokemonTypeFinder pokemonTypeFinderCache = new PokemonTypeFinder(pokeCachePokemonTypeRepository);

        try {
            List<PokeType> pokeTypes = pokemonTypeFinderCache.invoke(name);
            if(pokeTypes.isEmpty()){
                return pokemonTypeFinderApi.invoke(name);
            }
            else{
                return pokemonTypeFinderCache.invoke(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (PokeTypeException pe){
            pe.getMessage();
            return null;
        }
    }
}