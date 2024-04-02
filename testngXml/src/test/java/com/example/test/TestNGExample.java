package com.example.test;

import org.testng.annotations.Test;

public class TestNGExample {

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
