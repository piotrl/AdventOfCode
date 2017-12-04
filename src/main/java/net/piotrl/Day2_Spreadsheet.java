package net.piotrl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day2_Spreadsheet {

    public int calcChecksum(String input) {
        String[] lines = input.split("\n");
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            sum += calcLineChecksum(lines[i]);
        }
        return sum;
    }

    public int calcChecksumEvenlyDistributed(String input) {
        String[] lines = input.split("\n");
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            sum += calcLineChecksumEvenlyDivided(lines[i]);
        }
        return sum;
    }

    private int calcLineChecksum(String line) {
        List<Integer> numbers = getLineIntegers(line);

        Optional<Integer> max = numbers.stream().max(Comparator.comparingInt(o -> o));
        Optional<Integer> min = numbers.stream().min(Comparator.comparingInt(o -> o));
        int diff = max.orElse(0) - min.orElse(0);
        if (diff < 0) {
            throw new IllegalStateException("Max: " + max.get() + " Min: " + min.get());
        }
        return diff;
    }

    private int calcLineChecksumEvenlyDivided(String line) {
        List<Integer> numbers = getLineIntegers(line);
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (numbers.get(i) % numbers.get(j) == 0) {
                    return numbers.get(i) / numbers.get(j);
                }
            }
        }

        return 0;
    }

    private List<Integer> getLineIntegers(String line) {
        String[] digit = line.split("\\s+");

        return Arrays.stream(digit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
