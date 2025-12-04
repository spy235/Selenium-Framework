package helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

import utils.LanguageUtils;
import utils.LogUtils;

/**
 * Utility class for managing properties files.
 * 
 * <p>
 * This class provides methods for loading, reading, and writing properties
 * files.
 * </p>
 */
public class PropertiesHelpers {

	private static Properties properties;
	private static String linkFile;
	private static FileInputStream file;
	private static FileOutputStream out;
	private static String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

	/**
	 * Loads all predefined properties files.
	 * 
	 * @return A Properties object containing all the loaded properties.
	 */
	public static Properties loadAllFiles() {
		LinkedList<String> files = new LinkedList<>();
		// Add all file Properties
		files.add("src/test/resources/config/config.properties");
		files.add("src/test/resources/extent.properties");
		files.add("src/test/resources/config/data.properties");

		try {
			properties = new Properties();

			for (String f : files) {
				Properties tempProp = new Properties();
				linkFile = SystemHelpers.getCurrentDir() + f;
				file = new FileInputStream(linkFile);
				tempProp.load(file);
				properties.putAll(tempProp);
			}
			file.close();
			LogUtils.info("Loaded all properties files.");
			LogUtils.info(properties);
			return properties;
		} catch (IOException e) {
			LogUtils.warn("Warning !! Can not Load All File.");
			return new Properties();
		}
	}

	/**
	 * Returns the loaded properties.
	 * 
	 * @return The loaded Properties object.
	 */
	public static Properties getProperties() {
		return properties;
	}

	/**
	 * Sets the properties file to be used.
	 * 
	 * @param relPropertiesFilePath The relative path to the properties file.
	 */
	public static void setFile(String relPropertiesFilePath) {
		properties = new Properties();
		try {
			linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePath;
			file = new FileInputStream(linkFile);
			properties.load(file);
			file.close();
		} catch (Exception e) {
			LogUtils.warn("Warning !! Can not set Properties file.");
			e.printStackTrace();
		}
	}

	/**
	 * Sets the default properties file to be used.
	 */
	public static void setDefaultFile() {
		properties = new Properties();
		try {
			linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
			file = new FileInputStream(linkFile);
			properties.load(file);
			file.close();
		} catch (Exception e) {
			LogUtils.warn("Warning !! Can not set Default Properties file.");
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves the value associated with the specified key.
	 * 
	 * @param key The key whose value is to be retrieved.
	 * @return The value associated with the key, or null if the key does not exist.
	 */
	public static String getValue(String key) {
		String keyValue = null;
		try {
			if (file == null && properties == null) {
				setDefaultFile();
			}

			keyValue = properties.getProperty(key);
			return LanguageUtils.convertCharset_ISO_8859_1_To_UTF8(keyValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return keyValue;
		}
	}

	/**
	 * Sets the value for the specified key in the properties file.
	 * 
	 * @param key      The key to be set.
	 * @param keyValue The value to be associated with the key.
	 */
	public static void setValue(String key, String keyValue) {
		try {
			if (file == null) {
				properties = new Properties();
				file = new FileInputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
				properties.load(file);
				file.close();
				out = new FileOutputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
			}

			out = new FileOutputStream(linkFile);
			System.out.println(linkFile);
			properties.setProperty(key, keyValue);
			properties.store(out, "Set value to properties file success.");
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
