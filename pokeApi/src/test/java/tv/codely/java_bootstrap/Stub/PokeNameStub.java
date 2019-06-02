package tv.codely.java_bootstrap.Stub;

import tv.codely.java_bootstrap.Pokemon.Domain.PokeName;

public class PokeNameStub {

    public static PokeName create(String pokeName){
        return new PokeName(pokeName);
    }

    public static PokeName generateRandom() {

        String[] names = { "pikachu", "bulbasaur" };
        String randomName = "";
        randomName = names[(int) (Math.floor(Math.random() * ((names.length ))))];

        return new PokeName(randomName);
    }

}
/*"charizard", "ivysaur", "venusaur", "charmander", "charmeleon", "squirtle",
                "wartortle", "arbok", "nidorina", "ekans", "golbat", "zubat", "gloom", "venonat", "paras",
                "vulpix", "diglett", "mankey"*/