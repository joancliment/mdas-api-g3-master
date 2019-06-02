package tv.codely.java_bootstrap.Pokemon.Domain;

public class User {

    private UserID userID;

    public User(UserID userID) {
        this.userID = userID;
    }

    public UserID getId() {
        return userID;
    }

}
