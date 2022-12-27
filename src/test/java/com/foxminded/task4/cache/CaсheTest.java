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
public class CaсheTest {
    @Mock
    private Cache cache;


    @Test
    void checkIfItInCache_testCheckIfItInCache_whenStringIsAlreadyInCashe() {
        Mockito.when(cache.checkIfItInCache("Hello World!")).thenReturn(true);

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
        Mockito.when(cache.getValueFromCashe("Hello World!")).thenReturn(Map.of('c',1));

        Map<Character, Integer> actual = cache.getValueFromCashe("Hello World!");
        Map<Character, Integer> expected = Map.of('c',1);
        assertEquals(expected, actual);
    }

    @Test
    void getValueFromCashe_testGetValueFromCashe_whenThereIsNoValue() {
        Mockito.when(cache.getValueFromCashe("Hello World!")).thenReturn(null);
        Map<Character, Integer> actual = cache.getValueFromCashe("Hello World!");

        assertNull(actual);

    }

}
