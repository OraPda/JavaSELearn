package com.Annotation;

public @interface XiaoRuiFristAnnotation {
    String name();
    int age() default 18;
    String[] address();
}
