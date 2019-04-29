package tv.codely.java_bootstrap;

import java.util.Scanner;

public class CLIController {

    public void init(){
        System.out.println ("Por favor introduzca un id de un pokemon por teclado");
        String pokemonTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        pokemonTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        PokemonTypeFinder pokeFinder = new PokemonTypeFinder();
        try {
            pokeFinder.poketypesFinder(pokemonTeclado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
