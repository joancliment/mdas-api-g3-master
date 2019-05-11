package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypeRepositoryShould {

    @Test
    public void pokemon__pokeApi__search__pokeType() throws IOException {
        String name = "pikachu";
        List<PokeType> expectedPokemonTypes = new ArrayList<>();
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();

    }

    @Test
    public void pokemon__cache__search__listEmpty(){
        PokeCachePokemonTypeRepository pokecachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
    }

    @Test
    public void pokemon__cache__search__pokeType(){
        PokeCachePokemonTypeRepository pokecachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
    }
}
