package com.foxminded.task4.cache;

import java.util.LinkedHashMap;

public class Cache {
    private LinkedHashMap<String, Integer> cashedValues;

    private String inputString;

    public Cache() {
    }

    public LinkedHashMap<String, Integer> getCashedValues() {
        return cashedValues;
    }

    public void setCashedValues(LinkedHashMap<String, Integer> cashedValues) {
        this.cashedValues = cashedValues;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
