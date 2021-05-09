package com.IOCContainerFromAliExpress.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Inject {
}
