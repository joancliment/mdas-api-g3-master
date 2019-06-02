package tv.codely.java_bootstrap.Pokemon.Domain;

public class PokeType {

    int slot;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokeType(String name) {
        this.name = name;
    }
}
