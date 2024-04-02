package com.example.test;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestNGExample {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] { TestNGExample.class });
        testNG.run();
    }

    @Test
    public void testAddition() {
        int result = 2 + 3;
        System.out.println("Result of addition: " + result);
        assert result == 5;
    }

    @Test
    public void testSubtraction() {
        int result = 5 - 3;
        System.out.println("Result of subtraction: " + result);
        assert result == 2;
    }
}
