package net.piotrl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6_InfinityLoopTest {

    @Test
    void examplePuzzle() {
        String input = "0\t2\t7\t0";
        int expectedResult = 5;

        verify(input, expectedResult);
    }

    @Test
    void fullPuzzle() {
        String input = "5\t1\t10\t0\t1\t7\t13\t14\t3\t12\t8\t10\t7\t12\t0\t6";
        int expectedResult = 5042;

        verify(input, expectedResult);
    }

    private void verify(String input, int expectedResult) {
        Day6_InfinityLoop service = new Day6_InfinityLoop();
        int result = service.howManyIterationsTillInifinityLoopIsFound(input);
        assertEquals(expectedResult, result);
    }
}