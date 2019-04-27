package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.util.List;

public class PokemonClient {

    String pokename = "Charmander";

    public static void main(String[] args) {
        CLIProtocol clip = new CLIProtocol();
        List<PokemonType> types = clip.getPokeTypeById(1);
        types.forEach((p) -> {System.out.println(p.getType().getName());});
    }


}
