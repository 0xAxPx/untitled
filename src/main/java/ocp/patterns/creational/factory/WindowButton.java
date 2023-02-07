package ocp.patterns.creational.factory;

public class WindowButton implements Button {
    @Override
    public void render() {
        System.out.println("Window button - render");
    }

    @Override
    public void onClick() {
        System.out.println("Window button - onClick");
    }
}
