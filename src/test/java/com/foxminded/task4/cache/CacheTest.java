package com.foxminded.task4.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CacheTest {
    @Mock
    private Cache cache;

    private final String value = "Hello World!";

    @Test
    void checkIfItInCache_testCheckIfItInCache_whenStringIsAlreadyInCashe() {
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(true);

        boolean actual = cache.checkIfValueAlreadyItIn(value);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void checkIfItInCache_testCheckIfItInCache_whenInputNull() {
        Mockito.when(cache.checkIfValueAlreadyItIn(null)).thenReturn(false);

        boolean actual = cache.checkIfValueAlreadyItIn(null);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void checkIfItInCache_testCheckIfItInCache_whenThereIsNoValueInCashe() {
        boolean actual = cache.checkIfValueAlreadyItIn(value);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenThereIsValue() {
        Mockito.when(cache.getValue(value)).thenReturn(Map.of('c', 1));

        Map<Character, Integer> actual = cache.getValue(value);
        Map<Character, Integer> expected = Map.of('c', 1);
        assertEquals(expected, actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenThereIsNoValue() {
        Mockito.when(cache.getValue(value)).thenReturn(null);
        Map<Character, Integer> actual = cache.getValue(value);

        assertNull(actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenInputNull() {
        Mockito.when(cache.getValue(null)).thenReturn(null);
        Map<Character, Integer> actual = cache.getValue(null);

        assertNull(actual);
    }
}
