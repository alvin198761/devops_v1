package org.alvin.opsdev.core.annotation;


import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.commons.bean.enums.OSType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tangzhichao on 2016/11/2.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Executor {

    OSType value() default OSType.LINUX;

    ExecutorType executor();
}
