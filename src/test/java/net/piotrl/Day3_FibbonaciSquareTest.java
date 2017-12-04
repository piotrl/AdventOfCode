package net.piotrl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3_FibbonaciSquareTest {

    @Test
    void scenario1() {
        verify(1, 0);
    }

    @Test
    void scenario2() {
        verify(2, 1);
    }

    @Test
    void scenario9() {
        verify(9, 2);
    }

    @Test
    void scenario5() {
        verify(5, 2);
    }

    @Test
    void scenario12() {
        verify(12, 3);
    }

    @Test
    void scenario23() {
        verify(23, 2);
    }

    @Test
    void scenario1024() {
        verify(1024, 31);
    }

    @Test
    void fullInput() {
        verify(265149, 438);
    }

    void verify(int input, int expectedResult) {
        Day3_FibbonaciSquare service = new Day3_FibbonaciSquare();
        int result = service.howManySteps(input);
        assertEquals(expectedResult, result);
    }

}