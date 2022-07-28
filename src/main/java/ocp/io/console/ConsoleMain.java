package ocp.io.console;

import java.io.Console;

public class ConsoleMain {

    public static void main(String[] args) {

        Console console = System.console();

        console.writer().println("HELLO");


    }


}
