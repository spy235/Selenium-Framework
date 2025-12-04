package exceptions;
/**
 * Exception thrown when an invalid URL is provided for a remote WebDriver.
 * 
 * <p>
 * This exception extends {@link FrameworkException} and is used to indicate issues with the URL for a remote WebDriver.
 * </p>
 */
@SuppressWarnings("serial")
public class InvalidRemoteWebDriverURLException extends FrameworkException {
	/**
     * Constructs a new InvalidRemoteWebDriverURLException with the specified detail message.
     * 
     * @param message Details about the exception or custom message.
     */
	public InvalidRemoteWebDriverURLException(String message) {
		super(message);
	}

	 /**
     * Constructs a new InvalidRemoteWebDriverURLException with the specified detail message and cause.
     * 
     * @param message Details about the exception or custom message.
     * @param cause The cause of the exception.
     */
	public InvalidRemoteWebDriverURLException(String message, Throwable cause) {
		super(message, cause);
	}

}
