package net.piotrl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day3_FibbonaciSquare {

    public int howManySteps(final int input) {
        Double log = Math.sqrt(input);

        double powerBase = Math.ceil(log);
        if (powerBase % 2 == 0) {
            powerBase++;
        }
        Double nearestRightBottomCorner = Math.pow(powerBase, 2);
        Double nearestLeftBottomCorner = nearestRightBottomCorner - powerBase + 1;
        Double nearestLeftTopCorner = nearestLeftBottomCorner - powerBase + 1;
        Double nearestRightTopCorner = nearestLeftTopCorner - powerBase + 1;

        List<Double> corners = Arrays.asList(nearestLeftBottomCorner, nearestLeftTopCorner, nearestRightBottomCorner, nearestRightTopCorner);
        System.out.println(corners);

        Double nearestCorner = corners.stream()
                .min(Comparator.comparingDouble(o -> (Math.abs(o - input))))
                .get();
        Double up = (log / 2);
        Double left = Math.abs(up.intValue() - Math.abs((nearestCorner - input)));

        System.out.println("log: " + log.intValue());
        System.out.println("up: " + up.intValue());
        System.out.println("left: " + left.intValue());
        System.out.println("nearestCorner: " + nearestCorner.intValue());
        return up.intValue() + left.intValue();
    }
}
