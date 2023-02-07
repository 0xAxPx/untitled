package ocp.patterns.creational.abstractfactory;

public class Application {

    private CheckBox checkBox;
    private Button button;

    public Application(UIAbstractFactory factory) {
        checkBox = factory.createCheckBox();
        button = factory.createButton();
    }

    public void paint() {
        checkBox.paint();
        button.paint();
    }

    public static void main(String[] args) {
        Application winApp = new Application(new WinFactory());
        Application htmlApp = new Application(new HtmlFactory());

        winApp.paint();
        htmlApp.paint();
    }
}
