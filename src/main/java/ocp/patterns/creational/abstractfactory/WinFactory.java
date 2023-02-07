package ocp.patterns.creational.abstractfactory;

public class WinFactory implements UIAbstractFactory{
    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
