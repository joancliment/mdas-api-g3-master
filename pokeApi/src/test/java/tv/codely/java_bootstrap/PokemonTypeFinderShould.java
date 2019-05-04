package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
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
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = mock(PokeApiPokemonTypeRepository.class);
        PokemonTypeFinder typeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenReturn(expectedPokemonTypes);

        assertEquals(typeFinder.invoke(pokemonName), expectedPokemonTypes);
    }

    @Test
    public void pokemon__found__PokeTypeException() throws PokeTypeException, IOException {
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = mock(PokeApiPokemonTypeRepository.class);
        PokemonTypeFinder typeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenThrow(new PokeTypeException());

        assertThrows(PokeTypeException.class, () -> typeFinder.invoke(pokemonName));
    }

    @Test
    public void pokemon__Poke_Api__Exception() throws IOException {
        PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = mock(PokeApiPokemonTypeRepository.class);
        PokemonTypeFinder typeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenThrow(new IOException());
        assertThrows(IOException.class, () -> typeFinder.invoke(pokemonName));

    }

}
