package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequenceCheck {

    public static void main(String[] args) {
        List<String> newPass = Arrays.asList("baacbab", "accdb", "baacba");
        List<String> oldPass = Arrays.asList("abdbc", "ach", "abb");
        int n = newPass.size();
        List<String> ans = new ArrayList<>();

        for (int _i = 0; _i < n; _i++) {
            String _new = newPass.get(_i);
            String _old = oldPass.get(_i);
            int i = 0, j = 0;

            while (i < _new.length() && j < _old.length()) {
                char ch = _old.charAt(j);
                char te = (ch == 'a') ? 'z' : (char) (ch - 1);

                if (_new.charAt(i) == ch || _new.charAt(i) == te) {
                    j++;
                }
                i++;
            }

            if (j == _old.length()) {
                ans.add("YES");
            } else {
                ans.add("NO");
            }
        }

        for (String result: ans) {
            System.out.print(result + " ");
        }
    }
}
