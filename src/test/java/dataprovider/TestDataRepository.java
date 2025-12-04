package dataprovider;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dto.TestDataDto;
import dto.User;
import dto.User.UserKey;
import helpers.InMemory;

public class TestDataRepository {
    private static final Logger logger = LogManager.getLogger(TestDataRepository.class);


    public static String getAppUrl() throws Exception {
        String url = InMemory.getInstance().getAppURL();
        logger.debug("Retrieved appURL: " + url);
        return url;
    }

    public static User getUser(String key) throws Exception {
        UserKey userKey = UserKey.valueOf(key);
        List<User> users = InMemory.getInstance().getUsers();
        logger.debug("Users loaded: " + users);
        List<User> user = users.stream().filter(us -> userKey.equals(us.getUserKey())).collect(Collectors.toList());
        if (user.size() > 1) {
            logger.warn("Multiple user details for the same key in test data, using the first match");
        }
        if (user.isEmpty()) {
            logger.error("No user found for key: " + key);
            throw new Exception("User not found for key: " + key);
        }
        return user.get(0);
    }

  
//    public static void updateScriptNumber(String newScriptNumber) throws Exception {
//        TestDataDto obj = InMemory.getInstance();
//        obj.setScriptnumber(newScriptNumber);
//        InMemory.updateInstance(obj);
//    }


}
