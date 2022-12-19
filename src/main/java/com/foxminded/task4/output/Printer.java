package com.foxminded.task4.output;

import java.util.LinkedHashMap;
import java.util.Map;

public class Printer {
    public static String printResult(LinkedHashMap<String, Integer> result) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<String, Integer> mapElement :
                result.entrySet()) {
            stringResult.append("\"").append(mapElement.getKey()).append("\" - ").append(mapElement.getValue()).append("\n");
        }
        return stringResult.toString();
    }
}
