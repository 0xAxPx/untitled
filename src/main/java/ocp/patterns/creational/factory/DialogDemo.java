package ocp.patterns.creational.factory;

import java.util.Scanner;

public class DialogDemo {

    private static Dialog dialog;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter value (1,2):");
        while (in.hasNext()) {
            String s = in.next();
            if (s.equalsIgnoreCase("1")) {
                dialog = new WindowDialog();
            } else if (s.equalsIgnoreCase("2")) {
                dialog = new HtmlDialog();
            } else {
                throw new IllegalArgumentException("No such objects");
            }

            System.out.println("Dialog: " + dialog.toString());


        }



    }



}
