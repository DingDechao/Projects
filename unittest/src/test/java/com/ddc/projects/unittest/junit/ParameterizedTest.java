package com.ddc.projects.unittest.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

    private double expected;
    private double number1;
    private double number2;

    @Parameters
    public static Collection<Double[]> getParameters() {
        return Arrays.asList(new Double[][]{
                {2.0, 1.0, 1.0},
                {3.0, 1.0, 2.0},
                {4.0, 1.0, 3.0}
        });
    }

    public ParameterizedTest(double expected, double number1, double number2) {
        this.expected = expected;
        this.number1 = number1;
        this.number2 = number2;
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(number1, number2), 0);
    }
}
