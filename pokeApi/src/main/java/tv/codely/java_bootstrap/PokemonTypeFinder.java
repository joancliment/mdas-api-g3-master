package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinder {

    public List<PokeType> poketypesFinder(String pokeName) throws IOException, PokeTypeException{

        HTTPProtocol httpp = new HTTPProtocol();
        List<PokeType> typesHttp = null;
        System.out.println("Ejecución usando HTTP Protocol");
        System.out.println("Pokemon: Bulbasaur, tipo:");
        typesHttp = httpp.getPokemonByName(pokeName);
        typesHttp.forEach((t) -> {System.out.println(t.getName());});
        return  typesHttp;

    }
}
