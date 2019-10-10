package co.goho.qingxu.shiro.config.datasource;

import java.lang.annotation.*;

/**
 * @author ttllihao
 * @description: AOP切换数据源注解，默认值mysql，即MySQL是默认主数据源
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "";
}
