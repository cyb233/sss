package moe.shuvi.log;

import java.lang.annotation.*;

/**
 * @ClassName LogAnnotation
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/4 14:06
 * @Version 1.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    /** 模块 :记录用户操作所在的当前模块*/
    String title() default "";

    /** 功能：记录用户当前真正的操作 */
    String action() default "";
}
