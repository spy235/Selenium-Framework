package dto;

import com.google.gson.annotations.SerializedName;

public class User {
    public enum UserKey {
        @SerializedName("app_User")
        app_User_valid,app_User_invalid
    }

    private String password;
    private String username;
    private UserKey userKey;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserKey getUserKey() {
        return userKey;
    }

    public void setUserKey(UserKey userKey) {
        this.userKey = userKey;
    }
}
