package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public void recurse(List<String> res, int open, int close, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (open < n) {
            recurse(res, open + 1, close, s + "(", n);
        }

        if (close < open) {
            recurse(res, open, close + 1, s + ")", n);
        }
    }
}
