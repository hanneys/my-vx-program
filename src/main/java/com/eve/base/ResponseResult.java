package com.eve.base;

import java.lang.annotation.*;

/**
 * @Author hanneys
 * @Date 2021/4/27 15:12
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
