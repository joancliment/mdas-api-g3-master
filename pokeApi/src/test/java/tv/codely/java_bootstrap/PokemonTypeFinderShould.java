package tv.codely.java_bootstrap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;



public class PokemonTypeFinderShould {


	@Test
	public void pokemon_found() throws IOException, PokeTypeException{
		String pokemonTeclado = "pikachu";

		PokemonTypeFinder pokeFinder = new PokemonTypeFinder();
        final List<PokeType> pokeTypes = pokeFinder.Find(pokemonTeclado);

		final String actualPokemonTypeName = pokeTypes.get(0).getName();
		final String expectedPokemonTypeName = "electric";

		assertEquals(expectedPokemonTypeName, actualPokemonTypeName);
	}

	@Test
	public void testPokeTypeException() throws IOException, PokeTypeException {
		String pokemonTeclado = "";

		PokemonTypeFinder pokeFinder = new PokemonTypeFinder();


		final String expectedPokemonTypeException = "Pokemon no encontrado";

		Exception exception = assertThrows(PokeTypeException.class, () ->
				pokeFinder.Find(pokemonTeclado));
		assertEquals(expectedPokemonTypeException, exception.getMessage());

	}

}
