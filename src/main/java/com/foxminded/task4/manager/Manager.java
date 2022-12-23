package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;

import java.util.Map;

public class Manager {
    private final Calculation calculation;
    private final Cache cache;

    public Manager(Calculation calculation, Cache cache) {
        this.calculation = calculation;
        this.cache = cache;
    }

    public Map<Character, Integer> getResult(String inputString) {

        Map<Character, Integer> result;
        if (this.cache.checkIfItInCache(inputString)) {
            result = cache.getValueFromCashe(inputString);
            System.out.println("Cash used!");
        } else {
            result = calculation.calculate(inputString);
            cache.putInCache(inputString, result);
            System.out.println("Cash not used!");
        }
        return result;
    }
}
