package com.foxminded.task4;

import com.foxminded.task4.manager.Manager;
import com.foxminded.task4.output.Printer;

import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Manager manager = new Manager();

        Printer printer = new Printer();

        LinkedHashMap<String, Integer> result = manager.getResult("Hello World!");

        printer.print(result);

    }
}
