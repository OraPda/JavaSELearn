package com.Annotation;

public @interface ScondAnnotation {
    String value();  //特殊属性,在使用时如果只有一个value属性，可以省略value
    String name() default "小锐";
}
