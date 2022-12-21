package com.foxminded.task4;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;
import com.foxminded.task4.manager.Manager;
import com.foxminded.task4.output.Printer;

import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Calculation calculation = new Calculation();
        Cache cache = new Cache();

        Manager manager = new Manager(calculation, cache);

        Map<String, Integer> result1 = manager.getResult("Hello World!");

        String res = Printer.printResult(result1);
        System.out.println(res);

        Map<String, Integer> result2 = manager.getResult("Hello World!");

        String res2 = Printer.printResult(result2);
        System.out.println(res2);


//        LinkedHashMap<String, Map<String, Integer>> all = cache.getCashedValues();
//
//        for (Map.Entry<String, Map<String, Integer>> mapElement : all.entrySet()) {
//            System.out.println();
//            System.out.println(mapElement.getKey());
//        }

    }
}
