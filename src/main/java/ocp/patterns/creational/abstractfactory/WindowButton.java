package ocp.patterns.creational.abstractfactory;

public class WindowButton implements Button {
    @Override
    public void paint() {
        System.out.println("Window button - paint");
    }


}
