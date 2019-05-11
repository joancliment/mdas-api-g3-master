package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Test;
import tv.codely.java_bootstrap.Stub.PokeNameStub;
import tv.codely.java_bootstrap.Stub.PokeTypeListStub;

import static org.mockito.Mockito.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PokemonTypeFinderShould {
    PokeName pokemonName = PokeNameStub.generateRandom();
    PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = mock(PokeApiPokemonTypeRepository.class);
    PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = mock(PokeCachePokemonTypeRepository.class);
    PokemonTypeFinder typeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository, pokeCachePokemonTypeRepository);

    @Test
    public void pokemon__found__pokeType() throws IOException, PokeTypeException {
        PokeTypeList expectedPokemonTypes = PokeTypeListStub.generateRandom();
        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenReturn(expectedPokemonTypes);
        when(pokeCachePokemonTypeRepository.search(pokemonName)).thenThrow(PokeTypeException.class);
        assertEquals(typeFinder.invoke(pokemonName), expectedPokemonTypes);
        verify(pokeApiPokemonTypeRepository, times(1)).search(pokemonName);
    }

    @Test
    public void pokemon__found__PokeTypeException() throws PokeTypeException, IOException {

        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenThrow(PokeTypeException.class);
        when(pokeCachePokemonTypeRepository.search(pokemonName)).thenThrow(PokeTypeException.class);
        assertThrows(PokeTypeException.class, () -> typeFinder.invoke(pokemonName));
    }

    @Test
    public void pokemon__Poke_Api__Exception() throws IOException {

        when(pokeApiPokemonTypeRepository.search(pokemonName)).thenThrow(new IOException());
        when(pokeCachePokemonTypeRepository.search(pokemonName)).thenThrow(PokeTypeException.class);
        assertThrows(IOException.class, () -> typeFinder.invoke(pokemonName));

    }

}
