package net.piotrl;

import java.util.Arrays;

public class Day5_Jumper {
    public int countJumpsToLeaveInput(String input) {
        Integer[] counters = counters(input);
        int currentElement = 0;
        int previousElement = 0;
        int iterations = 0;
        while (currentElement >= 0 && currentElement < counters.length) {
            previousElement = currentElement;
            currentElement = currentElement + counters[currentElement];
            counters[previousElement]++;
            iterations++;
        }
        return iterations;
    }

    public int countJumpsToLeaveInputPart2(String input) {
        Integer[] counters = counters(input);
        int currentElement = 0;
        int previousElement = 0;
        int iterations = 0;
        while (currentElement >= 0 && currentElement < counters.length) {
            previousElement = currentElement;
            currentElement = currentElement + counters[currentElement];
            if (counters[previousElement] >= 3) {
                counters[previousElement]--;
            } else {
                counters[previousElement]++;
            }
            iterations++;
        }
        return iterations;
    }

    private Integer[] counters(String input) {
        return Arrays.stream(input.split("\n"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
    }
}
