package driver;

import io.cucumber.java.Scenario;
import utils.LogUtils;

/**
 * Manages the Cucumber Scenario instances for the Cannatrek framework.
 * 
 * <p>
 * This class provides methods to set and retrieve the current Scenario
 * instance, allowing for logging and other operations within a test scenario
 * context.
 * </p>
 */
public class ScenarioManager {

	private static Scenario scenario;

	/**
	 * Retrieves the current Cucumber Scenario instance.
	 * 
	 * <p>
	 * Logs the scenario details using {@code LogUtils.info}.
	 * </p>
	 * 
	 * @return The current Scenario instance.
	 */
	public static Scenario getScenario() {
		LogUtils.info("Scenario in ScenarioManager: " + scenario);
		return scenario;
	}

	/**
	 * Sets the current Cucumber Scenario instance.
	 * 
	 * @param scenario The Scenario instance to be set.
	 */
	public static void setScenario(Scenario scenario) {
		ScenarioManager.scenario = scenario;
	}
}
