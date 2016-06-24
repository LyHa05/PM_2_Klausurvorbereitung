package dennis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Urheberrechte.class)
@Urheberrecht() // Default
@Urheberrecht(name = "Person2",jahr = 2002)
public @interface Urheberrecht {
  String name() default "Dennis Pietruck";
  int jahr() default 2016;
}
