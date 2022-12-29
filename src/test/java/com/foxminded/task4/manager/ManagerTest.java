package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ManagerTest {
    @Mock
    private Cache cache;
    @Mock
    private Calculator calculator;

    private final String value = "Hello World!";

    @Test
    void getResult_testTransformMethodOfCalculation_whenInCacheNoValue() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(false);

        manager.getResult(value);

        Mockito.verify(calculator).transform(value);
    }

    @Test
    void getResult_testHowManyTimesTransformMethodOfCalculatorIsCalled_whenInCacheSomeValue() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(true);

        manager.getResult(value);

        Mockito.verify(calculator, times(0)).transform(value);
    }

    @Test
    void getResult_testGetValueFromCasheMethodOfCashe_whenInCacheSomeValue() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(true);

        manager.getResult(value);

        Mockito.verify(cache).getValue(value);
    }

    @Test
    void getResult_testGetResult_whenInputSomeValue() {
        Manager manager = new Manager(new Calculator(), new Cache());

        Map<Character, Integer> actual = manager.getResult(value);
        Map<Character, Integer> expected = Map.of('H', 1, 'e', 1, 'l', 3, 'o', 2, ' ', 1, 'W', 1, 'r', 1, 'd', 1, '!', 1);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_testGetResult_whenInputNull() {
        Manager manager = new Manager(new Calculator(), new Cache());

        Exception exception = assertThrows(NullPointerException.class,
                () -> manager.getResult(null));
        assertEquals("Cannot invoke \"String.toCharArray()\" because \"inputString\" is null", exception.getMessage());
    }

    @Test
    void getResult_testInvocationOfMethodsOfManagerCalculatorCacheClasses_whenOriginallyNoValueInCache() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));

        manager.getResult(value);

        InOrder order = Mockito.inOrder(manager, calculator, cache);

        order.verify(cache).checkIfValueAlreadyItIn(value);
        order.verify(calculator).transform(value);
        order.verify(cache, never()).getValue(value);


        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(true);
        manager.getResult(value);

        order.verify(cache).checkIfValueAlreadyItIn(value);
        order.verify(cache).getValue(value);
        order.verify(calculator, never()).transform(value);
    }

    @Test
    void getResult_testHowManyTimesTransformMethodOfCalculatorIsCalled_whenInCacheNoValue() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(false);

        manager.getResult(value);
        manager.getResult(value);

        Mockito.verify(calculator, times(2)).transform(value);
    }

    @Test
    void getResult_testHowManyTimesGetValueMethodOfCacheIsCalled_whenInCacheSomeValue() {
        Manager manager = Mockito.spy(new Manager(calculator, cache));
        Mockito.when(cache.checkIfValueAlreadyItIn(value)).thenReturn(true);

        manager.getResult(value);
        manager.getResult(value);

        Mockito.verify(cache, times(2)).getValue(value);
    }
}
