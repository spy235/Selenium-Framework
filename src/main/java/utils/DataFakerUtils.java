package utils;

import net.datafaker.Faker;

import java.util.Locale;

import constants.FrameworkConstants;

/**
 * Utility class for generating fake data using the Faker library.
 *
 * <p>This class provides methods to get and set a Faker instance with a specified locale.
 * It is designed to be used for generating test data in different locales.</p>
 *
 * @version 1.0
 * @since 2022
 */
public class DataFakerUtils {

    // Singleton instance of Faker
    private static Faker faker = null; // Default is English US

    /**
     * Retrieves the singleton Faker instance, initializing it with the locale
     * specified in {@link FrameworkConstants#LOCATE} if it hasn't been initialized yet.
     *
     * @return the singleton instance of Faker.
     */
    public static Faker getFaker() {
        if (faker == null) {
            faker = new Faker(new Locale(FrameworkConstants.LOCATE));
        }
        return faker;
    }

    /**
     * Sets the Faker instance.
     *
     * @param faker the new Faker instance to set.
     */
    public static void setFaker(Faker faker) {
        DataFakerUtils.faker = faker;
    }

    /**
     * Sets the locale for the Faker instance.
     *
     * <p>This method initializes a new Faker instance with the specified locale.</p>
     *
     * @param localeName the name of the locale to set, e.g., "en-US" or "vi".
     */
    public static void setLocate(String localeName) {
        faker = new Faker(new Locale(localeName));
    }
}
