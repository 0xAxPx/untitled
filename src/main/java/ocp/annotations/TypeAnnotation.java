package ocp.annotations;

import java.lang.annotation.Repeatable;

/**
 * @Target annotation takes an array of ElementType:
 *  (Applicable for OCP exam):
 * - Type
 * - Field
 * - Method
 * - Parameter
 * - Constructor
 * - Local Variables
 * - Annotation Type
 * - Type_Use
 */

//@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
//@Retention(RetentionPolicy.RUNTIME) //annotation is effective in .class and Runtime
//@Inherited // will be inherited by child classes
@Repeatable(TypeAnnotations.class) // when you want to specify annotation more than one i.e. with diff values @AnnotationCustom(1), @AnnotationCustom("Test")
public @interface TypeAnnotation {

    String danger() default "";
}
