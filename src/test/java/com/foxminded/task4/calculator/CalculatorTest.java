package com.foxminded.task4.calculator;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void transform_testTransformationIntoMap_whenStringValueInput() {
        Calculator calculator = new Calculator();
        Map<Character, Integer> actual = calculator.transform("Hello World!");
        Map<Character, Integer> expected = Map.of('H', 1, 'e', 1, 'l', 3, 'o', 2, ' ', 1, 'W', 1, 'r', 1, 'd', 1, '!', 1);

        assertEquals(expected, actual);
    }

    @Test
    void transform_testTransformationIntoMap_whenInputNull() {
        Calculator calculator = new Calculator();

        Exception exception = assertThrows(NullPointerException.class,
                () -> calculator.transform(null));
        assertEquals("Cannot invoke \"String.toCharArray()\" because \"inputString\" is null", exception.getMessage());
    }
}
