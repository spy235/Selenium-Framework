
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for date and time operations.
 *
 * <p>This class provides methods for getting the current date and time in various formats.</p>
 *
 * <p>This class is final and cannot be extended.</p>
 *
 * @version 1.0
 * @since 2022
 */
public final class DateUtils {
	// Private constructor to prevent instantiation
    private DateUtils() {
        super();
    }

    /**
     * Gets the current date and time as a string, with colons and spaces replaced by underscores.
     *
     * @return the current date and time as a string in the default format with colons and spaces replaced by underscores.
     */
    public static String getCurrentDate() {
        Date date = new Date();
        return date.toString().replace(":", "_").replace(" ", "_");
    }

    /**
     * Gets the current date and time formatted as dd/MM/yyyy HH:mm:ss.
     *
     * @return the current date and time as a string in the format dd/MM/yyyy HH:mm:ss.
     */
    public static String getCurrentDateTime() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(now);
    }
    /**
     * Gets the current date and time formatted as dd/MM/yyyy HH:mm:ss, with custom separator characters.
     *
     * @param separatorCharacter the character to use as a separator between date and time components.
     * @return the current date and time as a string with custom separator characters.
     */
    public static String getCurrentDateTimeCustom(String separator_Character) {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String timeStamp = formatter.format(now).replace("/", separator_Character);
        timeStamp = timeStamp.replace(" ", separator_Character);
        timeStamp = timeStamp.replace(":", separator_Character);
        return timeStamp;
    }

}
