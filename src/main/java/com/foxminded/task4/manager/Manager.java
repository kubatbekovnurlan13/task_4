package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;

import java.util.LinkedHashMap;

public class Manager {
    private final Calculation calculation;
    private final Cache cache;

    public Manager(Calculation calculation, Cache cache) {
        this.calculation = calculation;
        this.cache = cache;
    }

    public LinkedHashMap<String, Integer> getResult(String inputString) {

        LinkedHashMap<String, Integer> result;
        if (this.cache.isThereCash(inputString)) {
            result = this.cache.getCashedValues();
            System.out.println("Cash used!");
        } else {
            result = this.calculation.calculate(inputString);
            this.cache.setInputString(inputString);
            this.cache.setCashedValues(result);
            System.out.println("Cash not used!");
        }
        return result;
    }
}
