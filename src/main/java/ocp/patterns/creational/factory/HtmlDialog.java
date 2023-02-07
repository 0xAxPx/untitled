package ocp.patterns.creational.factory;

public class HtmlDialog extends Dialog {
    @Override
    Button createButton() {
        return new HtmlButton();
    }
}
