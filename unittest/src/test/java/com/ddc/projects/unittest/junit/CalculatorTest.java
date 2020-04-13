package com.ddc.projects.unittest.junit;

import static org.junit.Assert.*;
import org.junit.Test;

// This test class must be public
// no name conventions, but normally as XXXTest
// Junit3 need to extend TestCase, no need for Junit4
public class CalculatorTest {

    @Test
    // no name conventions, but normally as testXXX()
    public void testAdd() {
        Calculator calculator = new Calculator();
        double count = calculator.add(10, 20);
        assertEquals(30, count, 0);
    }
}
