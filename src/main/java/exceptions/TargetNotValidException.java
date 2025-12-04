package exceptions;

/**
 * Exception thrown when an invalid target environment is specified.
 * 
 * <p>
 * This exception extends {@link IllegalStateException} and is used to indicate
 * that the specified target environment is not supported.
 * </p>
 */
public class TargetNotValidException extends IllegalStateException {
	/**
	 * Constructs a new TargetNotValidException with the specified target
	 * environment.
	 * 
	 * @param target The target environment that is not supported.
	 */
	public TargetNotValidException(String target) {
		super(String.format("Target %s not supported. Use either local or gird", target));
	}

}
