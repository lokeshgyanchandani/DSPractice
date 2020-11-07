package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	Node left;
	Node right;
	int data;

	Node(int newData) {
		left = null;
		right = null;
		data = newData;
	}
}

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void printTree() {
		printTree(root);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	private void printTree(Node node) {
		if (node == null)
			return;

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}

	public void printleaf() {
		printl(root);
	}

	private void printl(Node node) {
		if (node == null)
			return;
		else if (node.left == null && node.right == null)
			System.out.println(node.data);
		else {
			printl(node.left);
			printl(node.right);
		}

	}

	public int size(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + size(node.left) + size(node.right);

	}

	public void printleft() {
		HashMap<Integer, Integer> hd = new HashMap<Integer, Integer>();
		printleft(root, 0, hd);
		Set<Integer> i = hd.keySet();
		for (int key : i) {
			System.out.println(hd.get(key));
		}
		// printleftqueue(root);
	}

	private void printleft(Node node, int i, HashMap<Integer, Integer> hd) {
		if (node == null) {
			return;
		} else {
			hd.put(i, node.data);
			printleft(node.left, i + 1, hd);
			printleft(node.right, i + 1, hd);
		}

	}

	static int preIndex = 0;

	public Node constructTree(int pre[]) {
		preIndex = 0;
		int size = pre.length;
		return preTree(pre, pre[0], Integer.MIN_VALUE,
				Integer.MAX_VALUE, size);
	}

	Node preTree(int pre[], int key, int min, int max, int size) {
		// Base case
		if (preIndex >= size)
			return null;

		Node root = null;

		if (key > min && key < max) {
			root = new Node(key);
			preIndex = preIndex + 1;

			if (preIndex < size) {
				root.left = preTree(pre, pre[preIndex], min, key, size);

				root.right = preTree(pre, pre[preIndex], key, max, size);
			}
		}

		return root;
	}

	private void printrightqueue(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {

			int len = queue.size();
			while (len > 0) {
				Node x = queue.peek();
				System.out.print(x.data + " ");
				if (len == 1) {
					System.out.println();
				}
				Node f = queue.poll();
				if (f.left != null)
					queue.add(f.left);
				if (f.right != null)
					queue.add(f.right);
				len--;
			}
		}
	}

	public void printright() {
		 HashMap<Integer, Integer> hd = new HashMap<Integer, Integer>();
		 printright(root, 0, hd);
		 Set<Integer> i = hd.keySet();
		 for (int key : i) {
		 System.out.println(hd.get(key));
		 }
		//printrightqueue(root);
	}

	private void printright(Node node, int i, HashMap<Integer, Integer> hd) {
		if (node == null) {
			return;
		} else {
			if (!hd.containsKey(i)) {
				hd.put(i, node.data);
			}
			printright(node.left, i + 1, hd);
			printright(node.right, i + 1, hd);
		}
	}

	public void printtop() {
		TreeMap<Integer, Integer> hd = new TreeMap<Integer, Integer>();
		printtop(root, 0, hd);
		Set<Integer> i = hd.keySet();
		for (int key : i) {
			System.out.println(hd.get(key));
		}
	}

	public void nearest(int k) {
		Node node = nearest(root, 17);
		System.out.println(node.data);
	}

	private Node nearest(Node node, int target) {

		Node nearest = node;
		while (node != null) {
			if (Math.abs(target - node.data) < Math.abs(target - nearest.data)) {
				nearest = node;
			}
			if (target < node.data)
				node = node.left;
			else
				node = node.right;
		}
		return nearest;
	}

	private void printtop(Node node, int i, TreeMap<Integer, Integer> hd) {
		if (node == null) {
			return;
		}
		Queue<Myqueue> queue = new LinkedList<>();
		queue.offer(new Myqueue(node, i));

		while (!queue.isEmpty()) {
			Myqueue x = queue.poll();
			if (!hd.containsKey(x.level))
				hd.put(x.level, x.node.data);
			if (x.node.left != null) {
				queue.offer(new Myqueue(x.node.left, x.level - 1));
			}
			if (x.node.right != null) {
				queue.offer(new Myqueue(x.node.right, x.level + 1));
			}
		}

	}

	public void ksmallest() {
		int k = ksmallest(root, 10);
		System.out.println("smallest kth element = " + k);
	}

	private int ksmallest(Node node, int k) {
		if (node == null)
			return -1;

		int size = size(node.left);
		if (size + 1 == k)
			return node.data;
		else if (size + 1 > k)
			return ksmallest(node.left, k);
		else
			return ksmallest(node.right, k - size - 1);

	}

	public void sumNumbers() {
		int i = sumNumbers(root, 0);
		System.out.println(i);
		int k = sumNumbersiter(root, 0);
		System.out.println(k);
	}

	private int sumNumbersiter(Node node, int i) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		int sum = 0;
		while (!s.isEmpty()) {
			Node temp = s.pop();
			if (temp.left == null && temp.right == null) {
				sum = sum + temp.data;
			}

			else {
				if (temp.left != null) {
					temp.left.data = temp.data * 10 + temp.left.data;
					s.push(temp.left);
				}

				if (temp.right != null) {
					temp.right.data = temp.data * 10 + temp.right.data;
					s.push(temp.right);
				}
			}
		}
		return sum;
	}

	public int sumNumbers(Node node, int sum) {
		if (node == null)
			return 0;

		sum = 10 * sum + node.data;

		if (node.left == null && node.right == null) {
			return sum;
		} else {
			return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree();
		t.insert(11);
		t.insert(5);
		t.insert(15);
		t.insert(1);
		t.insert(9);
		t.insert(7);
		t.insert(13);
		t.insert(24);
		t.insert(18);
		// t.insert(9);
		t.insert(10);
		// // t.insert(13);
		// // t.insert(24);
		// // t.insert(18);
		// t.insert(12);
		// t.insert(25);
		// t.insert(26);
		// t.insert(27);
		// t.insert(28);
		//t.printTree();
		// System.out.println();
		// t.printleaf();
		System.out.println();
		//t.printleft();
		t.printright();
		// t.printtop();
		// t.sumNumbers();
		// System.out.println();
		// t.ksmallest();
		// t.nearest(1);
		int arr[] = { 10, 5, 1, 7, 40, 50 };
		Node temp = t.constructTree(arr);
		t.postorder(temp);
	}

	private void postorder(Node temp) {
			if(temp == null)
				return;
			postorder(temp.left);
			postorder(temp.right);
			System.out.println(temp.data);
	}

}

class Myqueue {
	int level;
	Node node;

	public Myqueue(Node node, int level) {
		this.level = level;
		this.node = node;
	}
}