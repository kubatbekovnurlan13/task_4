package com.foxminded.task4.output;

import java.util.Map;

public class Printer {
    public static String printResult(Map<Character, Integer> result) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, Integer> mapElement : result.entrySet()) {
            stringResult.append("\"").append(mapElement.getKey()).append("\" - ").append(mapElement.getValue()).append("\n");
        }
        return stringResult.toString();
    }
}
