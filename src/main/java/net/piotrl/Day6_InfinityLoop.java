package net.piotrl;

import java.util.*;

public class Day6_InfinityLoop {
    public int howManyIterationsTillInifinityLoopIsFound(String input) {
        Integer[] numbers = Arrays.stream(input.split("\t")).map(Integer::parseInt).toArray(Integer[]::new);
        Set<String> visitedCombinations = new HashSet<>();
        String combination = Arrays.toString(numbers);
        int combinations = 0;

        do {
            System.out.println(combination);
            visitedCombinations.add(combination);
            int maxIndex = this.getMaxIndex(numbers);
            int maxValue = numbers[maxIndex];
            System.out.println("-> " + maxIndex + " " + maxValue);
            numbers[maxIndex] = 0;
            rearrangeNumbers(numbers, maxIndex, maxValue);

            combination = Arrays.toString(numbers);

            combinations++;
        }
        while (!visitedCombinations.contains(combination));


        return combinations;
    }

    private void rearrangeNumbers(Integer[] numbers, int maxIndex, int maxValue) {
        for (int i = 1; i <= maxValue; i++) {
            numbers[(maxIndex + i) % (numbers.length)]++;
        }
    }

    private int getMaxIndex(Integer[] currentCombination) {
        int maxI = 0;
        int max = currentCombination[maxI];

        for (int i = 0; i < currentCombination.length; i++) {
            if (currentCombination[i] > max) {
                maxI = i;
                max = currentCombination[i];
            }
        }

        return maxI;
    }
}
