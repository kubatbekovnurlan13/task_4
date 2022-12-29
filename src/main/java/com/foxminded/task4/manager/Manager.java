package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculator.Calculator;

import java.util.Map;

public class Manager {
    private final Calculator calculator;
    private final Cache cache;

    public Manager(Calculator calculator, Cache cache) {
        this.calculator = calculator;
        this.cache = cache;
    }

    public Map<Character, Integer> getResult(String inputString) {

        Map<Character, Integer> result;
        if (cache.checkIfValueAlreadyItIn(inputString)) {
            result = cache.getValue(inputString);
        } else {
            result = calculator.transform(inputString);
            cache.putIn(inputString, result);
        }
        return result;
    }
}
