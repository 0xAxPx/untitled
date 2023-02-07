package ocp.patterns.creational.abstractfactory;

public class WindowCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Window checkbox - paint");
    }


}
