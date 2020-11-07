package com.ds.trie;

import java.util.LinkedList;

class TrieNode {
	char value;
	boolean end;
	LinkedList<TrieNode> childs = new LinkedList<>();

	TrieNode(char c) {
		this.value = c;
		this.end = false;
		this.childs = new LinkedList<TrieNode>();
	}

	public TrieNode isChild(char c) {
		if (childs != null) {
			for (TrieNode child : childs) {
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
					current.childs.add(new TrieNode(c));
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
			if (current.end == true)
				return true;
			return false;
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
