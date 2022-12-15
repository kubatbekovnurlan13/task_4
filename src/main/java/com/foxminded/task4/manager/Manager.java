package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;

import java.util.LinkedHashMap;

public class Manager {
    private Calculation calculation = new Calculation();
    private Cache cache = new Cache();
    private LinkedHashMap<String, Integer> result;

    public LinkedHashMap<String, Integer> getResult(String inputString) {

        if (cache.getInputString() != null && cache.getInputString().equals(inputString)) {
            result = cache.getCashedValues();
            System.out.println("Cashe used!");
        } else {
            result = calculation.calculate(inputString);
            cache.setInputString(inputString);
            cache.setCashedValues(result);
        }

        return result;
    }
}
