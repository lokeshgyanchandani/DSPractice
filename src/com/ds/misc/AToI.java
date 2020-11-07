package com.ds.misc;

public class AToI {
    private static int atoi(String s) {
        String s1 = s.trim();
        if (s1.isEmpty()) {
            return 0;
        }
        int conversion = 0;
        int firstIndex = 0;
        char firstLetter = Character.MIN_VALUE;
        if (s1.charAt(firstIndex) == '+' || s1.charAt(firstIndex) == '-') {
            firstLetter = s1.charAt(0);
            firstIndex = 1;
        }
        if ((firstIndex == 1 && s1.length() == 1) || ! isInt(s1.charAt(firstIndex))) {
            System.out.println("No conversion could be performed");
            return 0;
        }
        for (int index = firstIndex; index < s1.length(); index++) {
            char currentChar = s1.charAt(index);
            if (isInt(currentChar)) {
                int currentVal = Integer.parseInt("" + currentChar);
                if ((Integer.MAX_VALUE - currentVal) / 10 < conversion) {
                    System.out.println(conversion + " -> " + (Integer.MAX_VALUE - 10 * conversion) + " -> " + currentVal);
                    if (firstLetter == Character.MIN_VALUE || firstLetter == '+')
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                conversion = 10 * conversion + currentVal;
            } else
                break;
        }
        if (firstLetter == Character.MIN_VALUE || firstLetter == '+') {
            return conversion;
        } else
            return -1 * conversion;
    }

    private static boolean isInt(char s) {
        try {
            Integer.parseInt("" + s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String args[]) {
            System.out.println(atoi("   -1213"));
    }
}
