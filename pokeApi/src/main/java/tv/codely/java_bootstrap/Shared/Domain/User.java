package tv.codely.java_bootstrap.Shared.Domain;

public class User {

    private UserID userID;

    public User(UserID userID) {
        this.userID = userID;
    }

    public UserID getId() {
        return userID;
    }

}
