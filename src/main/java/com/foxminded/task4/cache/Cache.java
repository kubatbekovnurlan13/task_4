package com.foxminded.task4.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Cache {
    private final LinkedHashMap<String, Map<String, Integer>> cashedValues = new LinkedHashMap<>(5) {
        protected boolean removeEldestEntry(Map.Entry<String, Map<String, Integer>> eldest) {
            int MAX = 5;
            return size() > MAX;
        }
    };

    public boolean checkIfItInCache(String newStringValue) {
        for (Map.Entry<String, Map<String, Integer>> mapElement : cashedValues.entrySet()) {
            if (Objects.equals(mapElement.getKey(), newStringValue)) {
                return true;
            }
        }
        return false;
    }

    public void putInCache(String newStringValue, Map<String, Integer> newMapValue) {
        cashedValues.put(newStringValue, newMapValue);
    }

//    public LinkedHashMap<String, Map<String, Integer>> getCashedValues() {
//        return cashedValues;
//    }

    public Map<String, Integer> getValueFromCashe(String newStringValue) {
        return cashedValues.get(newStringValue);
    }
}
