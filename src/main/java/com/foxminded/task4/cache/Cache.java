package com.foxminded.task4.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    private final LinkedHashMap<String, Map<Character, Integer>> cashedValues = new LinkedHashMap<>();

    public void putInCache(String newStringValue, Map<Character, Integer> newMapValue) {
        cashedValues.put(newStringValue, newMapValue);
    }

    public boolean checkIfItInCache(String newStringValue) {
        return cashedValues.containsKey(newStringValue);
    }


    public Map<Character, Integer> getValueFromCashe(String newStringValue) {
        return cashedValues.get(newStringValue);
    }
}
