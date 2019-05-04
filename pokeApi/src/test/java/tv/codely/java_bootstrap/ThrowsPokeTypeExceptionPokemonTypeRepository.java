package tv.codely.java_bootstrap;
import java.util.List;

public class ThrowsPokeTypeExceptionPokemonTypeRepository implements PokemonTypeRepository {

    @Override
    public List<PokeType> search(String pokeName) throws PokeTypeException {
        throw new PokeTypeException();

    }

}
