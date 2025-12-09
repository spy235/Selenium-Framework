
package annotations;

import enums.AuthorType;
import enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {
	/**
	 * Specifies the author(s) of the method.
	 * @return An array of 'Author Type' objects containing author information.
	*/
	public AuthorType[] author();

	/**
	 * Specifies the category or type associated with the method.
	 * @return An array of 'CategoryType' objects containing category information.
	*/
	public CategoryType[] category();

}
