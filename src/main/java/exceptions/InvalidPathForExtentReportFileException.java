package exceptions;

/**
 * Exception thrown when an invalid path is provided for an Extent report file.
 * 
 * <p>
 * This exception extends {@link InvalidPathForFilesException} and is used to
 * indicate issues with the path for an Extent report file.
 * </p>
 */
@SuppressWarnings("serial")
public class InvalidPathForExtentReportFileException extends InvalidPathForFilesException {
	/**
	 * Constructs a new InvalidPathForExtentReportFileException with the specified
	 * detail message.
	 * 
	 * @param message Details about the exception or custom message.
	 */
	public InvalidPathForExtentReportFileException(String message) {
		super(message);
	}

	/**
	 * Constructs a new InvalidPathForExtentReportFileException with the specified
	 * detail message and cause.
	 * 
	 * @param message Details about the exception or custom message.
	 * @param cause   The cause of the exception.
	 */
	public InvalidPathForExtentReportFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
