package com.foxminded.task4;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.transformation.Transformation;
import com.foxminded.task4.manager.Manager;
import com.foxminded.task4.output.Printer;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        app();
    }

    private static void app() {
        Manager manager = new Manager(new Transformation(), new Cache());

        boolean run = true;
        System.out.println("Welcome to application!");
        System.out.println("To stop the application enter -> stop");

        while (run) {
            System.out.print("Enter some value:  ");
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            System.out.println("Value: " + value);

            if (Objects.equals(value, "stop")) {
                run = false;
            } else {
                Map<Character, Integer> result1 = manager.getResult(value);

                String res = Printer.printResult(result1);
                System.out.println(res);
            }
        }
    }
}
