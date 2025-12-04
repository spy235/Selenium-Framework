package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

/**
 * Configuration interface to manage application settings.
 * 
 * <p>
 * This interface uses the AeonBits Owner library to map configuration properties from various sources 
 * including system properties, environment variables, and properties files.
 * </p>
 * 
 * <p>
 * The configuration properties are loaded with a merge policy, allowing values to be overridden by those 
 * defined later in the source list.
 * </p>
 */

@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties",
        "system:env",
        "file:./src/test/resources/config/config.properties",
        "file:./src/test/resources/config/data.properties"})

public interface Configuration extends Config {
	
	/**
     * Retrieves the target environment.
     * 
     * @return The target environment as a String.
     */

    @Key("TARGET")
    String TARGET();
    
    /**
     * Retrieves the browser type.
     * 
     * @return The browser type as a String.
     */

    @Key("BROWSER")
    String BROWSER();
    
    /**
     * Retrieves the headless mode setting.
     * 
     * @return True if headless mode is enabled, otherwise false.
     */

    @Key("HEADLESS")
    Boolean HEADLESS();
    
    /**
     * Retrieves the CRM URL.
     * 
     * @return The CRM URL as a String.
     */

    @Key("URL_CRM")
    String URL_CRM();
    
    /**
     * Retrieves the remote URL.
     * 
     * @return The remote URL as a String.
     */

    @Key("REMOTE_URL")
    String REMOTE_URL();
    
    /**
     * Retrieves the remote port.
     * 
     * @return The remote port as a String.
     */

    @Key("REMOTE_PORT")
    String REMOTE_PORT();
    
    /**
     * Retrieves the path to the Excel data file.
     * 
     * @return The path to the Excel data file as a String.
     */

    @Key("EXCEL_DATA_FILE_PATH")
    String EXCEL_DATA_FILE_PATH();

}
