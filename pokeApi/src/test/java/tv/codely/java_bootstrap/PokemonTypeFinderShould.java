package tv.codely.java_bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinderShould {

	@Test
	void pokemon_pikachu() throws IOException, PokeTypeException{
		String pokemonTeclado = "pikachu";

		PokemonTypeFinder pokeFinder = new PokemonTypeFinder();
        final List<PokeType> pokeTypes = pokeFinder.Find(pokemonTeclado);

		final String actualPokemonTypeName = pokeTypes.get(0).getName();
		final String expectedPokemonTypeName = "electric";

		assertEquals(expectedPokemonTypeName, actualPokemonTypeName);
	}

	@Test
	void pokemon_not_found() throws IOException, PokeTypeException{
		String pokemonTeclado = "";

		PokemonTypeFinder pokeFinder = new PokemonTypeFinder();
		final List<PokeType> pokeTypes = pokeFinder.Find(pokemonTeclado);

		final String actualPokemonTypeName = pokeTypes.get(0).getName();
		final String expectedPokemonTypeName = "Pokemon no encontrado";

		assertEquals(expectedPokemonTypeName, actualPokemonTypeName);
	}

}
