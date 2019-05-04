package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PokemonTypeFinderShould {
    String pokemonName = "random_pokemon";

    @Test
    public void pokemon__found__pokeType() throws IOException, PokeTypeException {
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
        ThrowsPokeTypeExceptionPokemonTypeRepository throwsPokeTypeExceptionPokemonTypeRepository = new ThrowsPokeTypeExceptionPokemonTypeRepository();
        PokemonTypeFinder pokeFinder = new PokemonTypeFinder(throwsPokeTypeExceptionPokemonTypeRepository);
        assertThrows(PokeTypeException.class, () -> pokeFinder.invoke(pokemonName));

    }

    @Test
    public void pokemon__Poke_Api__Exception() throws IOException {

        ThrowsIOExceptionPokemonTypeRepository throwsIOExceptionPokemonTypeRepository = new ThrowsIOExceptionPokemonTypeRepository();
        PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(throwsIOExceptionPokemonTypeRepository);
        assertThrows(IOException.class, () -> pokemonTypeFinder.invoke(pokemonName));

    }

}
