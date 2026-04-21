package com.ds.companies.amazon.leetcode.OA;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
}

class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean hasForbiddenSubstring(String s, int start) {
        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
            if (node.isEnd) return true;
        }
        return false;
    }
}

public class MaximumQualifiedSubstringTrie {

    public static int maxQualifiedSubstring(String word, String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < word.length(); right++) {
            while (left <= right && trie.hasForbiddenSubstring(word, left)) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxQualifiedSubstring("abcd", new String[]{"a", "d"})); // Output: 2
        System.out.println(maxQualifiedSubstring("aaaa", new String[]{"ab"})); // Output: 4
    }
}
