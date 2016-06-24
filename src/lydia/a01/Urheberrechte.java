package lydia.a01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Urheberrechte {
	public String urheber() default "Lydia Pflug";
	public LocalDateTime datumUhrzeit default LocalDateTime.of(2016,06,24,9,10);
}
