package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.Scanner;

public class PokemonTypeCLIController {

    public static void main(String[] args) {

        System.out.println("Por favor introduce el nombre de un pokemon por teclado");
        Scanner scanner = new Scanner(System.in); //Creación de un objeto Scanner
        String pokemonName = scanner.nextLine(); //Invocamos un método sobre un objeto Scanner

        PokeApiPokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokeFinder = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepository);
        try {
            PokeTypeList pokeType = pokeFinder.invoke(new PokeName(pokemonName));
            pokeType.get().forEach((t) -> {
                System.out.println(t.getName());});
        } catch (PokeTypeException e) {
            System.out.println(e.getMessage());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}

