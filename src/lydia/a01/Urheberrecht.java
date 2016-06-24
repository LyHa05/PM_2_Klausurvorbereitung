package lydia.a01;

/** 
 * @author Lydia Pflug
 * @datum 24.06.2016
 * Interface, das Annotation Urheberrecht beschreibt.
 * */

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Urheberrecht(jahr = 2016)
@Repeatable(value = Urheberrechte.class)
public @interface Urheberrecht {
	public String urheber() default "Lydia Pflug";
	public int jahr() default 1988;
}

