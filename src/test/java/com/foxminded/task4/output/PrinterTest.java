package com.foxminded.task4.output;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;
import com.foxminded.task4.manager.Manager;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    @Test
    void printResult_testPrintResult_whenSomeValuesInput() {
        Calculation calculation = new Calculation();
        Cache cache = new Cache();

        Manager manager = new Manager(calculation, cache);

        Map<Character, Integer> result = manager.getResult("Hello World!");

        String actual = Printer.printResult(result);
        String expected =
                """
                        "H" - 1
                        "e" - 1
                        "l" - 3
                        "o" - 2
                        " " - 1
                        "W" - 1
                        "r" - 1
                        "d" - 1
                        "!" - 1
                        """;
        assertEquals(expected, actual);
    }
}
