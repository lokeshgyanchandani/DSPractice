package com.ds.trie;

import java.util.LinkedList;

class TrieNodeImpl{
	char content;
	boolean isEnd;
	int count;
	LinkedList<TrieNodeImpl> childList;

	public TrieNodeImpl(char c) {
		childList = new LinkedList<TrieNodeImpl>();
		isEnd = false;
		content = c;
		count = 0;
	}

	public TrieNodeImpl subNode(char c) {
		if (childList != null)
			for (TrieNodeImpl eachChild : childList)
				if (eachChild.content == c)
					return eachChild;
		return null;
	}
}

class TrieImpl {
	private TrieNodeImpl root;

	// Constructor
	public TrieImpl() {
		root = new TrieNodeImpl(' ');
	}

	// Function to insert word

	public void insert(String word) {
		if (search(word) == true)
			return;
		TrieNodeImpl current = root;
		for (char ch : word.toCharArray()) {
			TrieNodeImpl child = current.subNode(ch);
			if (child != null)
				current = child;
			else {
				current.childList.add(new TrieNodeImpl(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
	}

	/* Function to search for word */
	public boolean search(String word) {
		TrieNodeImpl current = root;
		for (char ch : word.toCharArray()) {
			if (current.subNode(ch) == null)
				return false;
			else
				current = current.subNode(ch);
		}
		if (current.isEnd == true)
			return true;
		return false;
	}

	/* Function to remove a word */
	public void remove(String word) {
		if (search(word) == false) {
			System.out.println(word + " does not exist in trie\n");
			return;
		}
		TrieNodeImpl current = root;
		for (char ch : word.toCharArray()) {
			TrieNodeImpl child = current.subNode(ch);
			if (child.count == 1) {
				current.childList.remove(child);
				return;
			} else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}
}

public class trieImplementation {

	public static void main(String[] args) {
		TrieImpl t = new TrieImpl();
		t.insert("ashish");
		t.insert("abhishek");
		t.insert("ashok");
		t.insert("amit");
		t.insert("aman");

		boolean x = t.search("ashish");
		System.out.println(x);

		x = t.search("abhi");
		System.out.println(x);

	}
	// Scanner scan = new Scanner(System.in);
	// /* Creating object of AATree */
	// trie t = new trie();
	// System.out.println("Trie Test\n");
	// char ch;
	// /* Perform tree operations */
	// do
	// {
	// System.out.println("\nTrie Operations\n");
	// System.out.println("1. insert ");
	// System.out.println("2. delete");
	// System.out.println("3. search");
	//
	// int choice = scan.nextInt();
	// switch (choice)
	// {
	// case 1 :
	// System.out.println("Enter string element to insert");
	// t.insert( scan.next() );
	// break;
	// case 2 :
	// System.out.println("Enter string element to delete");
	// try
	// {
	// t.remove( scan.next() );
	// }
	// catch (Exception e)
	// {
	// System.out.println(e.getMessage()+" not found ");
	// }
	// break;
	// case 3 :
	// System.out.println("Enter string element to search");
	// System.out.println("Search result : "+ t.search( scan.next() ));
	// break;
	// default :
	// System.out.println("Wrong Entry \n ");
	// break;
	// }
	//
	// System.out.println("\nDo you want to continue (Type y or n) \n");
	// ch = scan.next().charAt(0);
	// } while (ch == 'Y'|| ch == 'y');
	// }

}
