package dataprovider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dto.User;

public class TestDataProvider {
	private static final Logger logger = LogManager.getLogger(TestDataProvider.class);

	public static String getUserCredential(String user, String element) throws Exception {
	    logger.info("Searching '" + user + "' in json data");

	    User ur = TestDataRepository.getUser(user);
	    if (ur == null) {
	        logger.error("User object is null for user: " + user);
	        throw new NullPointerException("User object is null for user: " + user);
	    }

	    try {
	        switch (element) {
	            case "Password":
	                logger.info("Password successfully fetched");
	                return ur.getPassword();
	            case "Username":
	                logger.info("Username successfully fetched");
	                return ur.getUsername();
	            default:
	                logger.error("Invalid element provided: " + element);
	                throw new IllegalArgumentException("Invalid element provided: " + element);
	        }
	    } catch (AssertionError e) {
	        logger.error("Assertion error: " + e.getMessage());
	        throw e; // Rethrow the error to fail the test
	    }
	}

}
