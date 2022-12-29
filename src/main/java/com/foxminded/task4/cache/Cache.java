package com.foxminded.task4.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    private final LinkedHashMap<String, Map<Character, Integer>> cashedValues = new LinkedHashMap<>();

    public void putIn(String newStringValue, Map<Character, Integer> newMapValue) {
        cashedValues.put(newStringValue, newMapValue);
    }

    public boolean checkIfValueAlreadyItIn(String newStringValue) {
        return cashedValues.containsKey(newStringValue);
    }

    public Map<Character, Integer> getValue(String newStringValue) {
        return cashedValues.get(newStringValue);
    }
}
