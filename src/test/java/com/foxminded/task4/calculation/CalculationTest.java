package com.foxminded.task4.calculation;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    @Test
    void calculate_testCalculate_whenStringValueInput() {
        Calculation calculation = new Calculation();
        Map<Character, Integer> actual = calculation.calculate("Hello World!");
        Map<Character, Integer> expected = Map.of('H', 1, 'e', 1, 'l', 3, 'o', 2, ' ', 1, 'W', 1, 'r', 1, 'd', 1, '!', 1);

        assertEquals(expected, actual);
    }
}
