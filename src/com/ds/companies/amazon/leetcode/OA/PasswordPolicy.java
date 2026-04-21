package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PasswordPolicy {

    /****** Solution 1 ******/

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String[] newpass = new String[n];
        String[] old = new String[n];

        for (int i = 0; i < n; i++) {
            newpass[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            old[i] = scanner.nextLine();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String np = newpass[i];
            String oldpass = old[i];
            int sz1 = np.length();
            int sz2 = oldpass.length();
            int j = 0, k = 0;

            while (j < sz1 && k < sz2) {
                char comp = np.charAt(j);
                char next = (comp == 'z') ? 'a' : (char) (comp + 1);

                if (comp == oldpass.charAt(k) || oldpass.charAt(k) == next) {
                    k++;
                }
                j++;
            }

            if (k == sz2) {
                result.append("YES ");
            } else {
                result.append("NO ");
            }
        }

        System.out.println(result.toString().trim());
    }

    /****** Solution 2 ******/

    public static List<String> checkPasswords(List<String> newPasswords, List<String> oldPasswords) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < newPasswords.size(); i++) {
            String newPassword = newPasswords.get(i);
            String oldPassword = oldPasswords.get(i);

            if (canTransformAndMatch(newPassword, oldPassword)) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }

        return result;
    }

    private static boolean canTransformAndMatch(String newPassword, String oldPassword) {
        if (oldPassword.length() > newPassword.length()) {
            return false;
        }

        char[] newChars = newPassword.toCharArray();

        // Try transforming characters in the new password
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = getNextCharacter(newChars[i]);
        }

        // Check if oldPassword is a subsequence of newPassword after transformation
        return isSubsequence(oldPassword, new String(newChars));
    }

    private static char getNextCharacter(char ch) {
        return (char) ((ch - 'a' + 1) % 26 + 'a');
    }

    private static boolean isSubsequence(String sub, String main) {
        int subIndex = 0, mainIndex = 0;

        while (subIndex < sub.length() && mainIndex < main.length()) {
            if (sub.charAt(subIndex) == main.charAt(mainIndex)) {
                subIndex++;
            }
            mainIndex++;
        }

        return subIndex == sub.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solve(scanner);
        scanner.close();
    }

    public static void main2(String[] args) {
        List<String> newPasswords = Arrays.asList("baacab", "accdb", "baacba");
        List<String> oldPasswords = Arrays.asList("abdcbc", "ach", "abb");

        List<String> results = checkPasswords(newPasswords, oldPasswords);
        System.out.println(results);
    }
}
