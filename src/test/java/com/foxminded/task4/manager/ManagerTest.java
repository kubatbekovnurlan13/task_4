package com.foxminded.task4.manager;

import com.foxminded.task4.cache.Cache;
import com.foxminded.task4.calculation.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ManagerTest {
    @Mock
    private Cache cache;
    @Mock
    private Calculation calculation;

    @Test
    void getResult_testCalculateMethodOfCalculation_whenInCasheNoValue() {
        Manager manager = Mockito.spy(new Manager(calculation, cache));
        Mockito.when(cache.checkIfItInCache("Hello World!")).thenReturn(false);

        Map<Character, Integer> call = manager.getResult("Hello World!");

        Mockito.verify(calculation).calculate("Hello World!");
    }

    @Test
    void getResult_testHowManyTimesCalculateMethodOfCalculationIsCalled_whenInCasheSomeValue() {
        Manager manager = Mockito.spy(new Manager(calculation, cache));
        Mockito.when(cache.checkIfItInCache("Hello World!")).thenReturn(true);

        Map<Character, Integer> call1 = manager.getResult("Hello World!");
        Map<Character, Integer> call2 = manager.getResult("Hello World!");
        Map<Character, Integer> call3 = manager.getResult("Hello World!");

        Mockito.verify(calculation, times(0)).calculate("Hello World!");
    }


    @Test
    void getResult_testGetValueFromCasheMethodOfCashe_whenInCasheIsValue() {
        Manager manager = Mockito.spy(new Manager(calculation, cache));
        Mockito.when(cache.checkIfItInCache("Hello World!")).thenReturn(true);

        Map<Character, Integer> call = manager.getResult("Hello World!");

        Mockito.verify(cache).getValueFromCashe("Hello World!");
    }



    @Test
    void getResult_testGetResult_whenInputValue() {
        Manager manager = new Manager(new Calculation(), new Cache());

        Map<Character, Integer> actual = manager.getResult("Hello World!");
        Map<Character, Integer> expected = Map.of('H', 1, 'e', 1, 'l', 3, 'o', 2, ' ', 1, 'W', 1, 'r', 1, 'd', 1, '!', 1);
        assertEquals(expected, actual);
    }

    @Test
    void getResult_testGetResult_whenInputNull() {
        Manager manager = new Manager(new Calculation(), new Cache());

        Exception exception = assertThrows(NullPointerException.class,
                () -> manager.getResult(null));
        assertEquals("Cannot invoke \"String.toCharArray()\" because \"inputString\" is null", exception.getMessage());
    }
}
