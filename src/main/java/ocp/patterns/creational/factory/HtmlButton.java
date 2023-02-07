package ocp.patterns.creational.factory;

public class HtmlButton implements Button{

    @Override
    public void render() {
        System.out.println("HTML button - render");
    }

    @Override
    public void onClick() {
        System.out.println("HTML button - render");
    }
}
