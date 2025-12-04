package exceptions;

/**
 * Exception thrown when headless mode is not supported for a specified browser.
 * 
 * <p>
 * This exception extends {@link IllegalStateException} and is used to indicate
 * that headless mode is not supported for the given browser.
 * </p>
 */
public class HeadlessNotSupportedException extends IllegalStateException {
	/**
	 * Constructs a new HeadlessNotSupportedException with the specified browser
	 * name.
	 * 
	 * @param browser The name of the browser that does not support headless mode.
	 */
	public HeadlessNotSupportedException(String browser) {
		super(String.format("Headless not supported for %s browser", browser));
	}
}
