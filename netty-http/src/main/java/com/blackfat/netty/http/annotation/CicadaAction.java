package com.blackfat.netty.http.annotation;

import java.lang.annotation.*;

/**
 * Created by DD-PC6 on 2018/11/6.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CicadaAction {

    String value() default "" ;
}
