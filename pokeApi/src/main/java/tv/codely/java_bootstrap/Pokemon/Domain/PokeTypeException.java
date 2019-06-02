package tv.codely.java_bootstrap.Pokemon.Domain;

public class PokeTypeException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Pokemon no encontrado";
    }
}
