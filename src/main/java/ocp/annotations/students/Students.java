package ocp.annotations.students;

public class Students {

    @SafeVarargs
    final void print(int ... inst) {
        System.out.println("VarAgrs");
    }


    private String name;

}
