package com.ddc.projects.java11.unittest.junit.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class TestHamCrest {

    private List<String> list;

    @Before
    public void setup() {
        list = Arrays.asList("x", "y", "z");
    }

    @Test
    public void testWithoutHamCrest() {
        assertTrue(list.contains("x") || list.contains("y") || list.contains("z"));
    }

    @Test
    public void testWithHamCrest() {
        assertThat(list, hasItem(anyOf(equalTo("x"), equalTo("y"), equalTo("z"))));
    }
}
