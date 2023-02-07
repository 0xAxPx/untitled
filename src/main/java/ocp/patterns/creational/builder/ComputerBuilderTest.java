package ocp.patterns.creational.builder;

public class ComputerBuilderTest {


    public static void main(String[] args) {

        Computer computer = new Computer.ComputerBuilder()
                .setHDD("1")
                .setSSD("2")
                .setRAM("3")
                .build();

        System.out.printf("%s", computer.getHdd());
    }
}
