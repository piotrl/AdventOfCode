package net.piotrl;

public class DigitCaptcha {

    public int calcSum(String digitsString) {
        int sum = 0;
        String[] digits = digitsString.split("");
        for (int i = 0; i < digits.length; i++) {
            if (i == digits.length-1) {
                if (digits[i].equals(digits[0])) {
                    sum += Integer.parseInt(digits[i]);
                }
            } else if (digits[i].equals(digits[i + 1])) {
                sum += Integer.parseInt(digits[i]);
            }
        }

        return sum;
    }
}
