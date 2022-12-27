package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.transformation.Transformation;

import java.util.Map;

public class Manager {
    private final Transformation transformation;
    private final Cache cache;

    public Manager(Transformation transformation, Cache cache) {
        this.transformation = transformation;
        this.cache = cache;
    }

    public Map<Character, Integer> getResult(String inputString) {

        Map<Character, Integer> result;
        if (this.cache.checkIfItInCache(inputString)) {
            result = cache.getValueFromCashe(inputString);
//            System.out.println("Cash used!");
        } else {
            result = transformation.transform(inputString);
            cache.putInCache(inputString, result);
//            System.out.println("Cash not used!");
        }
        return result;
    }
}
