package ocp.patterns.creational.abstractfactory;

public class HtmlFactory implements UIAbstractFactory{
    @Override
    public CheckBox createCheckBox() {
        return new HtmlCheckBox();
    }

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
