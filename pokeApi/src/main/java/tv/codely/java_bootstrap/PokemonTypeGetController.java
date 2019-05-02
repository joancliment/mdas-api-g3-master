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
        PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);

        List<PokeType> pokeTypes = new ArrayList<>();
        try {
            return pokemonTypeFinder.invoke(name);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (PokeTypeException pe){
            pe.getMessage();
            return null;
        }
    }
}


    /*private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/