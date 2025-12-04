package dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TestDataDto {

    @SerializedName("app_URL")
    private String appURL;

    @SerializedName("Users")
    private List<User> users;

    // Getters and setters
    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
