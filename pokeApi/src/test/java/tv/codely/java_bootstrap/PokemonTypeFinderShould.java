package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PokemonTypeFinderShould {

    @Test
    public void pokemon__found__pokeType() throws IOException, PokeTypeException {
        String pokemonName = "random_pokemon";
        List<PokeType> expectedPokemonTypes = new ArrayList<>();
        expectedPokemonTypes.add(new PokeType("random_pokemon_type"));

        Map<String, List<PokeType>> inMemoryPokemonTypes =
                Collections.singletonMap(pokemonName, expectedPokemonTypes);
        InMemoryPokemonTypeRepository inMemoryPokemonTypeRepository = new InMemoryPokemonTypeRepository(inMemoryPokemonTypes);

        PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(inMemoryPokemonTypeRepository);
        final List<PokeType> actualPokemonTypes = pokemonTypeFinder.invoke(pokemonName);

        assertEquals(expectedPokemonTypes, actualPokemonTypes);

        final Integer expectedRepositoryCalls = 1;
        assertEquals(expectedRepositoryCalls, inMemoryPokemonTypeRepository.calls());
    }

    @Test
    public void pokemon__found__PokeTypeException() throws PokeTypeException {
        String pokemonTeclado = "";
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
        PokemonTypeFinder pokeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
        assertThrows(PokeTypeException.class, () -> pokeFinder.invoke(pokemonTeclado));

    }

    @Test
    public void pokemon__Poke_Api__Exception() throws IOException {

        String pokemonTeclado = "bulbasaur";
        MockPokemonTypeRepositoryException pokeTypeRepository = new MockPokemonTypeRepositoryException();
        assertThrows(IOException.class, () -> pokeTypeRepository.search(pokemonTeclado));

    }

}
