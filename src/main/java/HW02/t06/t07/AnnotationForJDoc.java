package HW02.t06.t07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Documented
public @interface AnnotationForJDoc  {
    String doc() default
            "Created fo AtomicBoat class? witch have a nested class called " +
                    "EngineForAtominBoat with the only method bonvoyage";
}
