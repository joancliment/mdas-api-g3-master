package tv.codely.java_bootstrap.Shared.Domain;

public class PokeTypeException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Pokemon no encontrado";
    }
}
