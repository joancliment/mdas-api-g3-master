package tv.codely.java_bootstrap.Pokemon.Domain;

import tv.codely.java_bootstrap.Shared.Domain.AggregateRoot;

public class UserPokeFavs extends AggregateRoot {

    PokeName pokeName;
    UserID userID;

    public UserID getUserID() {
        return userID;
    }

    public PokeName getPokeName() {
        return pokeName;
    }

    public UserPokeFavs(PokeName pokeName, UserID userID) {
        this.pokeName = pokeName;
        this.userID = userID;
    }

    public static UserPokeFavs publish(UserID userID, PokeName name) {
        UserPokeFavs userPokeFavs = new UserPokeFavs(name, userID);
        PokeFavsAdded pokeFavsAdded = new PokeFavsAdded(name.get(), userID.getValue());
        userPokeFavs.record(pokeFavsAdded);

        return userPokeFavs;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPokeFavs that = (UserPokeFavs) o;

        if (!pokeName.get().equals(that.pokeName.get())) return false;
        return userID.getValue().equals(that.userID.getValue());
    }

}
