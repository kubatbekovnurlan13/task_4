package com.foxminded.task4.calculation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Calculation {
    public LinkedHashMap<String, Integer> calculate(String inputString) {
        String[] separatedString = separateStringAndMakeArray(inputString);

        return countChar(separatedString);
    }

    private String[] separateStringAndMakeArray(String inputString) {
        return inputString.split("");
    }

    private LinkedHashMap<String, Integer> countChar(String[] separatedString) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        for (String s : separatedString) {
            if (!result.containsKey(s)) {
                result.put(s, 1);
            } else {
                int newCounterValueOfChar = result.get(s) + 1;
                for (Map.Entry<String, Integer> mapElement :
                        result.entrySet()) {
                    if (Objects.equals(mapElement.getKey(), s)) {
                        mapElement.setValue(newCounterValueOfChar);
                    }
                }
            }
        }
        return result;
    }
}