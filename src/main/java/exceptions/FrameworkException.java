
package exceptions;

/**
 * Custom exception class for the Cannatrek framework.
 * 
 * <p>
 * This exception extends {@link RuntimeException} and is used to terminate the program when an exception occurs.
 * </p>
 */

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {
	/**
     * Constructs a new FrameworkException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public FrameworkException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new FrameworkException with the specified detail message and cause.
     * 
     * @param message The detail message.
     * @param cause The cause of the exception.
     */
    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
