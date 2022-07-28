package ocp.annotations;

/**
 * Marker Annotation is an annotation which does not contain any elements
 * When it is marker annotation then it might be used like
 *  - @Exercise
 *  - @Exercise() where parentheses are optional
 *
 *  When we have annotation element like method , it is no longer marker annotation
 *
 *  Annotation method are implicitly abstract public
 *
 *  Annotation can have static variable
 */
public @interface NonTypeAnnotation {

    int hoursPerDay() default 11;

    int startDay() default 4;

    String[] names();

    //Allow to not include parameterName while using @Annotation(value)
    //String value();

    public static final String MAX = "111";

    // Not compile since primitive is supported by Wrapper class - is not. List / Collections are not supported too
    //Integer height();

    //Not compile since multidimensional array is not supported
    //String[][] generalInfo();

    // Compile
    //Size size() default Size.SMALL;

    //Compile
    //Exercise exercise() default @Exercise(hoursPerDay=2);


}
