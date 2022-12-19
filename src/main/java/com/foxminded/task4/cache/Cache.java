package com.foxminded.task4.cache;

import java.util.LinkedHashMap;

public class Cache {
    private LinkedHashMap<String, Integer> cashedValues;
    private String inputString;

    public boolean isThereCash(String someString) {
        if (this.inputString == null) {
            return false;
        } else return someString.equals(this.inputString);
    }

    public LinkedHashMap<String, Integer> getCashedValues() {
        return this.cashedValues;
    }

    public void setCashedValues(LinkedHashMap<String, Integer> cashedValues) {
        this.cashedValues = cashedValues;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
