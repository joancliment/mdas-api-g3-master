package tv.codely.java_bootstrap;

import me.sargunvohra.lib.pokekotlin.model.PokemonType;

import java.io.IOException;
import java.util.List;

public class PokemonClient {

    public static void main(String[] args) throws IOException {
        CLIProtocol clip = new CLIProtocol();
        List<PokemonType> types = clip.getPokeTypeById(1);
        System.out.println("Ejecución usando la API por CLI");
        System.out.println("Pokemon: Bulbasaur, tipo:");
        types.forEach((p) -> {System.out.println(p.getType().getName());});
        System.out.println("");

        HTTPProtocol httpp = new HTTPProtocol();
        List<PokeType> typesHttp = null;
        try {
            System.out.println("Ejecución usando HTTP Protocol");
            System.out.println("Pokemon: Bulbasaur, tipo:");
            typesHttp = httpp.getPokemonByName("bulbasaur");
            typesHttp.forEach((t) -> {System.out.println(t.getName());});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
