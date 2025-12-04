package exceptions;

/**
 * Exception thrown when an invalid path is provided for an Excel file.
 * 
 * <p>
 * This exception extends {@link InvalidPathForFilesException} and is used to indicate issues with the path for an Excel file.
 * </p>
 */

public class InvalidPathForExcelException extends InvalidPathForFilesException{

	/**
     * Constructs a new InvalidPathForExcelException with the specified detail message.
     * 
     * @param message Details about the exception or custom message.
     */
	public InvalidPathForExcelException(String message) {
		super(message);
	}
	
	 /**
     * Constructs a new InvalidPathForExcelException with the specified detail message and cause.
     * 
     * @param message Details about the exception or custom message.
     * @param cause The cause of the exception.
     */
	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message,cause);
	}
}
