package com.foxminded.task4.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    private final LinkedHashMap<String, Map<String, Integer>> cashedValues = new LinkedHashMap<>(5) {
        protected boolean removeEldestEntry(Map.Entry<String, Map<String, Integer>> eldest) {
            int MAX = 5;
            return size() > MAX;
        }
    };

    public boolean checkIfItInCache(String newStringValue) {
        return cashedValues.containsKey(newStringValue);
    }

    public void putInCache(String newStringValue, Map<String, Integer> newMapValue) {
        cashedValues.put(newStringValue, newMapValue);
    }

    public Map<String, Integer> getValueFromCashe(String newStringValue) {
        return cashedValues.get(newStringValue);
    }
}
