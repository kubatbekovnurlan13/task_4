package com.foxminded.task4;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;
import com.foxminded.task4.manager.Manager;
import com.foxminded.task4.output.Printer;

import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Calculation calculation = new Calculation();
        Cache cache = new Cache();

        Manager manager = new Manager(calculation, cache);

        LinkedHashMap<String, Integer> result = manager.getResult("Hello World!");

        String res = Printer.printResult(result);

        System.out.println(res);
    }
}
