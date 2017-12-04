package net.piotrl;

public class DigitCaptchaHalfWayAround {

    public int calcSum(String digitsString) {
        int sum = 0;
        String[] digits = digitsString.split("");
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].equals(digits[nextDigit(i, digits.length)])) {
                sum += Integer.parseInt(digits[i]);
            }
        }

        return sum;
    }

    private int nextDigit(int i, int length) {
        return (i + (length / 2)) % length;
    }
}
