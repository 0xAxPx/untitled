package ocp.patterns.creational.abstractfactory;

public class HtmlButton implements Button {

    @Override
    public void paint() {
        System.out.println("HTML button - paint");
    }


}
