package chris.a01;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Copyright(jahr = 2016, name = "Chris Thiele", firma = "HAW Hamburg")
@Repeatable(Copyrights.class)
public @interface Copyright {
    String name() default "Name Name";
    String firma() default "Firma Firma";
    int jahr() default 2000;
}
