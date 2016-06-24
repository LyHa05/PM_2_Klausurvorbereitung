package thomas.a01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Thomas
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Urheberrechte.class)
@Urheberrecht()
@Urheberrecht(name = "Nicht Thomas",jahr = 2002)
public @interface Urheberrecht {
		public String name() default "Thomas";
		public int jahr() default 2016;

}
