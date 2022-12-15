package com.foxminded.task4.output;

import com.foxminded.task4.manager.Manager;

import java.util.LinkedHashMap;
import java.util.Map;

public class Printer {
    public void print(LinkedHashMap<String, Integer> result ){
        for (Map.Entry<String, Integer> mapElement :
                result.entrySet()) {
            System.out.println("\""+mapElement.getKey() + "\" - " + mapElement.getValue());
        }
    }
}
