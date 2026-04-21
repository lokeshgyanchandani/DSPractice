package com.ds.trie;

import java.util.LinkedList;

class TrieNode {
	char value;
	boolean end;
	LinkedList<TrieNode> children = new LinkedList<>();

	TrieNode(char c) {
		this.value = c;
		this.end = false;
		this.children = new LinkedList<TrieNode>();
	}

	public TrieNode isChild(char c) {
		if (children != null) {
			for (TrieNode child : children) {
				if (child.value == c)
					return child;
			}
		}
		return null;
	}

	static class TrieImp {
		private TrieNode root;

		public TrieImp() {
			root = new TrieNode(' ');
		}

		public void insert(String s) {
			TrieNode current = root;
			for (char c : s.toCharArray()) {
				TrieNode child = current.isChild(c);
				if (child != null)
					current = child;
				else {
					current.children.add(new TrieNode(c));
					current = current.isChild(c);
				}
			}
			current.end = true;
		}

		public boolean search(String s) {
			TrieNode current = root;
			for (char c : s.toCharArray()) {
				TrieNode child = current.isChild(c);
				if (child == null) {
					return false;
				} else
					current = current.isChild(c);
			}

            return current.end;
        }
	}
}

public class Trie {

	public static void main(String[] args) {
		TrieNode.TrieImp trie = new TrieNode.TrieImp();
		trie.insert("ashish");
		trie.insert("abhishek");
		trie.insert("amit");

		boolean x = trie.search("amit");
		System.out.println(x);
	}

}
