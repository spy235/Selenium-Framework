/**
 * This package contains custom annotations used within the Cannatrek framework.
 *
 * © 2024 Cannatrek. All rights reserved.
 */

package annotations;

import enums.AuthorType;
import enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to provide metadata for methods in the Cannatrek framework.
 * 
 * <p>
 * Use this annotation to specify the authors and categories associated with the
 * method.
 * </p>
 * 
 * <p>
 * The annotation has the following properties:
 * <ul>
 * <li><b>@Retention(RetentionPolicy.RUNTIME)</b> - Indicates that this
 * annotation is available at runtime.</li>
 * <li><b>@Target(ElementType.METHOD)</b> - Specifies that this annotation can
 * only be applied to methods.</li>
 * </ul>
 * </p>
 * 
 * © 2024 Cannatrek. All rights reserved.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

	/**
	 * Specifies the author(s) of the method.
	 * 
	 * @return An array of 'Author Type' objects containing author information.
	 */
	public AuthorType[] author();

	/**
	 * Specifies the category or type associated with the method.
	 * 
	 * @return An array of 'CategoryType' objects containing category information.
	 */
	public CategoryType[] category();

}
