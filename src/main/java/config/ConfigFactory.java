
package config;
import org.aeonbits.owner.ConfigCache;


/**
 * Factory class to provide the application configuration.
 */
public class ConfigFactory {
	// Private constructor to prevent instantiation
	private ConfigFactory() {
	}
	
	/**
	 * Retrieves the application configuration object.
	 * 
	 * @return An instance of the 'Configuration' class containing all configuration properties.
	 */
	public static Configuration getConfigs() {
		return ConfigCache.getOrCreate(Configuration.class);

	}

}
