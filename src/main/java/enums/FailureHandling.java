package enums;

/**
 * Enum representing the failure handling strategies in the Cannatrek framework.
 * 
 * <p>
 * This enum includes the following failure handling strategies:
 * <ul>
 *   <li>STOP_ON_FAILURE</li>
 *   <li>CONTINUE_ON_FAILURE</li>
 *   <li>OPTIONAL</li>
 * </ul>
 * </p>
 */
public enum FailureHandling {
    STOP_ON_FAILURE, CONTINUE_ON_FAILURE, OPTIONAL
}
