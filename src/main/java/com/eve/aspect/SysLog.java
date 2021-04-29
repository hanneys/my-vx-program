package com.eve.aspect;

import java.lang.annotation.*;

/**
 * @Author han aijun
 * @Date 2021/4/28 13:59
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)//注解不仅被保存到class文件中，jvm加载class文件之后，仍存在
@Target(ElementType.METHOD) //注解添加的位置
@Documented
public @interface SysLog {

    String description() default "";
}
