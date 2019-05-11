package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.Scanner;

public class PokemonTypeCLIController {

    public static void main(String[] args) {

        System.out.println("Por favor introduce el nombre de un pokemon por teclado");
        String pokemonTeclado = "";
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        pokemonTeclado = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner

        PokeApiPokemonTypeRepository pokeApiRepository = new PokeApiPokemonTypeRepository();
        PokeCachePokemonTypeRepository pokeCachePokemonTypeRepository = new PokeCachePokemonTypeRepository();
        PokemonTypeFinder pokeFinder = new PokemonTypeFinder(pokeApiRepository, pokeCachePokemonTypeRepository);
        try {
            PokeTypeList pokeType = pokeFinder.invoke(new PokeName(pokemonTeclado));
            pokeType.get().forEach((t) -> {
                System.out.println(t.getName());});
        } catch (PokeTypeException e) {
            System.out.println(e.getMessage());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}

