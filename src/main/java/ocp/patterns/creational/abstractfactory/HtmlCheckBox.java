package ocp.patterns.creational.abstractfactory;

public class HtmlCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("HTML checkbox - paint");
    }


}
