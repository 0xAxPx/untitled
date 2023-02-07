package ocp.patterns.creational.factory;

public class WindowDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowButton();
    }
}
