package com.ddc.projects.java8.annotationdemo;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Documented
public @interface Testable {
}

/*@Retention(RetentionPolicy.SOURCE)
public @interface Testable {
}*/

