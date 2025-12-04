
package config;
import org.aeonbits.owner.ConfigCache;

/**
 * © 2024 Cannatrek. All rights reserved.
 * 
 * <p>This utility class provides a static method to retrieve the application configuration. 
 * It utilizes the AeonBits Owner library's 'ConfigCache' to ensure a single instance of the 
 * Configuration class is used throughout the application.</p>
 */

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
