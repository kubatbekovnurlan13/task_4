package com.foxminded.task4.cache;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CaсheTest {
    private final Cache cache = new Cache();

    @Test
    void checkIfItInCache_testCheckIfItInCache_whenStringIsAlreadyInCashe() {
        cache.putInCache("Hello World!", Map.of('c', 1));

        boolean actual = cache.checkIfItInCache("Hello World!");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void checkIfItInCache_testCheckIfItInCache_whenThereIsNoValueInCashe() {
        boolean actual = cache.checkIfItInCache("Hello World!");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenThereIsValue() {
        cache.putInCache("Hello World!", Map.of('c', 1));

        Map<Character, Integer> actual = cache.getValueFromCashe("Hello World!");
        Map<Character, Integer> expected = Map.of('c',1);
        assertEquals(expected, actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenThereIsNoValue() {
        Map<Character, Integer> actual = cache.getValueFromCashe("Hello World!");
        assertNull(actual);
    }

}
