package com.foxminded.task4.transformation;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformationTest {

    @Test
    void transform_testTransformationIntoMap_whenStringValueInput() {
        Transformation transformation = new Transformation();
        Map<Character, Integer> actual = transformation.transform("Hello World!");
        Map<Character, Integer> expected = Map.of('H', 1, 'e', 1, 'l', 3, 'o', 2, ' ', 1, 'W', 1, 'r', 1, 'd', 1, '!', 1);

        assertEquals(expected, actual);
    }
}
