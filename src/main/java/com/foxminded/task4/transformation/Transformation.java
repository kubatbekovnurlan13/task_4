package com.foxminded.task4.transformation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Transformation {
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
            if (!result.containsKey(s)) {
                result.put(s, 1);
            } else {
                int newCounterValueOfChar = result.get(s) + 1;
                for (Map.Entry<Character, Integer> mapElement :
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