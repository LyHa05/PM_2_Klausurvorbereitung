package lydia.a01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author Lydia Pflug
 * @datum 24.06.2016
 * Interface, das Annotation Urheberrechte beschreibt.
 * */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Urheberrechte {
	Urheberrecht[] value();
}
