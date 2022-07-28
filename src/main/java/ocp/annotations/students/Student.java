package ocp.annotations.students;


import ocp.annotations.NonTypeAnnotation;
import ocp.annotations.TypeAnnotation;

@NonTypeAnnotation(names = {"Test, Test1"})
@TypeAnnotation(danger = "AAA")
@TypeAnnotation()
@TypeAnnotation(danger = "TEST")
public class Student {


}
