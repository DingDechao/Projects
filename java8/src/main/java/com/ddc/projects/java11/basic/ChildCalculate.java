package com.ddc.projects.java11.basic;

public class ChildCalculate extends Calculate {
	{
		super.s = "class:Sub";
	}
    String s = "class:Sub2";

    public float add(float a, float b) {
        return a + b;
    }

    public int add(int a, int b) {
        return 2 * a + b;
    }
}