package com.company;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt){

        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max){
        double value;

        while (true) {
            System.out.println(prompt);

            value = scanner.nextDouble();
            if (value > min && value <= max) {
                break;
            } else
                System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;

    }
}
