package com.binge.optimize.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface LogAble {

    boolean isNeed() default false;
}
