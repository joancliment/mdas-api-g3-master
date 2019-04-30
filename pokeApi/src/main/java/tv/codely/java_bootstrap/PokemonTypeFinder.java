package tv.codely.java_bootstrap;

import java.io.IOException;
import java.util.List;

public class PokemonTypeFinder {

    public List<PokeType> Find(String pokeName) throws IOException, PokeTypeException{

        PokeApiClient httpp = new PokeApiClient();
        List<PokeType> typesHttp = null;
        typesHttp = httpp.getPokemonByName(pokeName);
        typesHttp.forEach((t) -> {t.getName();});
        return  typesHttp;

    }
}
