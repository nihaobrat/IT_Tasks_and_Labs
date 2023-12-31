import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // цикл жизни устанавливаем в рантайме
@Target(ElementType.METHOD) // помечаем метод
public @interface DataProcessor {
    String comment() default "";
}
