package tv.codely.java_bootstrap.Pokemon.Domain;

import tv.codely.java_bootstrap.Shared.Domain.DomainEvent;

public class PokeFavsAdded implements DomainEvent {

    private static final String FULL_QUALIFIED_EVENT_NAME = "pokeFavs.published";

    private final String pokeName;
    private final String userID;

    public PokeFavsAdded(String pokeName, String userID) {
        this.pokeName = pokeName;
        this.userID = userID;
    }

    @Override
    public String eventName() {
        return FULL_QUALIFIED_EVENT_NAME;
    }

    public String pokeName() {
        return pokeName;
    }

    public String userID() {
        return userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokeFavsAdded that = (PokeFavsAdded) o;

        if (!pokeName.equals(that.pokeName)) return false;
        return userID.equals(that.userID);
    }

    @Override
    public int hashCode() {
        int result = pokeName.hashCode();
        result = 31 * result + userID.hashCode();
        return result;
    }
}
