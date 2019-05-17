package tv.codely.java_bootstrap.Shared.Domain;

import javax.websocket.PongMessage;

public class UserPokeFavs {

    PokeName pokeName;
    UserID userID;

    public UserPokeFavs(PokeName pokeName, UserID userID) {
        this.pokeName = pokeName;
        this.userID = userID;
    }
}
