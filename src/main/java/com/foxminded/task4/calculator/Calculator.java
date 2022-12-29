package com.foxminded.task4.calculator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Calculator {
    public Map<Character, Integer> transform(String inputString) {
        char[] separatedString = separateStringAndMakeArray(inputString);
        return countChar(separatedString);
    }

    private char[] separateStringAndMakeArray(String inputString) {
        return inputString.toCharArray();
    }

    private Map<Character, Integer> countChar(char[] separatedString) {
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (Character s : separatedString) {
            if (result.containsKey(s)) {
                int newCounterValueOfChar = result.get(s) + 1;
                for (Map.Entry<Character, Integer> mapElement :
                        result.entrySet()) {
                    if (Objects.equals(mapElement.getKey(), s)) {
                        mapElement.setValue(newCounterValueOfChar);
                    }
                }
            } else {
                result.put(s, 1);
            }
        }
        return result;
    }
}
