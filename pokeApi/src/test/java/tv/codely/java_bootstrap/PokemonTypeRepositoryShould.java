package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Test;
import tv.codely.java_bootstrap.Stub.PokeNameStub;
import tv.codely.java_bootstrap.Stub.PokeTypeListStub;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonTypeRepositoryShould {

    //public PokeNameStub pokeName = new PokeNameStub();
    PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
    PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
    PokeTypeList pokemonTypes;

    @Test
    public void pokemon__pokeApi__search__pokeType() throws IOException {
        pokemonTypes = pokeApiPokemonTypeRepository.search(PokeNameStub.generateRandom());
        boolean expected = (pokemonTypes.get().size() > 0);
        assertEquals(true, expected);
    }

    @Test
    public void pokemon__cache__search__listEmpty() throws IOException {
        assertThrows(PokeTypeException.class, () -> pokeCachePokemonTypeRepository.search(PokeNameStub.generateRandom()));
    }

    @Test
    public void pokemon__cache__search__pokeType() throws IOException {
        PokeName name = PokeNameStub.generateRandom();
        PokeTypeList pokeTypes = PokeTypeListStub.generateRandom();

        assertThrows(PokeTypeException.class, () -> pokeCachePokemonTypeRepository.search(name));

        pokeCachePokemonTypeRepository.save(name, pokeTypes);

        pokemonTypes = pokeCachePokemonTypeRepository.search(name);
        boolean expected = (pokemonTypes.get().isEmpty());
        assertEquals(false, expected);
    }
}
