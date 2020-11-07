package listjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

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

public class tree {
	private Node root;

	public tree() {
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

	public void dfs() {
		dfs(root);
		System.out.println();
		dfs1(root);
	}

	public void dfs(Node node) {
		Stack<Node> visited = new Stack<Node>();
		if (node == null)
			System.out.println("no path exists");
		else {
			visited.push(node);

			while (visited.empty() != true) {
				Node node1 = visited.pop();
				System.out.print(node1.data + " ");
				if (node1.right != null)
					visited.push(node1.right);
				if (node1.left != null)
					visited.push(node1.left);
			}
		}
	}

	public void dfs1(Node node) {
		if (node == null)
			return;
		else {
			System.out.print(node.data);
			dfs1(node.left);
			dfs1(node.right);
		}
	}

	public static int min = Integer.MAX_VALUE;

	public void printleaf() {
		int a[] = new int[20];
		int x = printleaf(root, 0, a, 0);
		System.out.println(x);
		// printl(root);
	}

	public void printl(Node node) {
		if (node == null)
			return;
		if ((node.left == null) && (node.right == null))
			System.out.println(node.data);
		printl(node.left);
		printl(node.right);
	}

	public int printleaf(Node node, int sum, int a[], int length) {
		if (node == null)
			return 0;
		sum = sum + node.data;
		a[length] = node.data;
		length++;
		if (node.right != null)
			printleaf(node.right, sum, a, length);
		if (node.left != null)
			printleaf(node.left, sum, a, length);

		if (node.right == null && node.left == null) {
			// sum = sum+node.data;
			// System.out.println(sum);
			if (sum < min) {
				min = sum;
			}
			if (sum == 20) {
				for (int i = 0; i < length; i++) {
					System.out.println(a[i]);
				}
			}
		}
		return min;

	}

	private void printTree(Node node) {
		if (node == null)
			return;

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}

	public void printleft() {
		HashMap<Integer, Integer> hd = new HashMap<Integer, Integer>();
		printleft(root, 0, hd);
		Set<Integer> i = hd.keySet();
		for (int keys : i) {
			System.out.println(hd.get(keys));
		}
	}

	public void printleft(Node node, int index, HashMap<Integer, Integer> hd) {
		if (node == null)
			return;

		// if(hd.containsKey(index))

		// {//hd.remove(index);

		hd.put(index, node.data);
		// }
		printleft(node.left, index + 1, hd);
		printleft(node.right, index + 1, hd);

	}

	public void size() {
		boolean i = isbal(root);
		System.out.println(i);
	}

	public boolean isbal(Node node) {
		if (height(node) == -1)
			return false;
		else
			return true;
	}

	public void height() {
		int x = height(root);
		System.out.println(x);
	}

	public int height(Node node) {
		if (node == null)
			return 0;
		else
			return Math.max(height(node.left) + 1, height(node.right) + 1);

	}

	public void lca() {
		// Node x = lca(root, 11, 15);
		Node x = lcabst(root, 4, 9);
		System.out.println(x.data);
	}

	public Node lcabst(Node node, int x, int y) {
		if (node == null)
			return null;

		if (node.data > x && node.data < y)
			return node;
		else if (x < node.data && y < node.data)
			return lcabst(node.left, x, y);
		else
			return lcabst(node.right, x, y);
	}

	public Node lca(Node node, int x, int y) {
		if (node == null)
			return null;

		if (node.data == x || node.data == y)
			return node;

		Node right = lca(node.right, x, y);
		Node left = lca(node.left, x, y);

		if (right != null && left != null) {
			return node;
		} else if (right != null) {
			return right;
		} else
			return left;

	}

	public static Node pre = null;

	public void inorderpre() {
		// Node pre = new Node(2);
		inorderpre(root, 20);
		if (pre != null)
			System.out.println(pre.data);
	}

	public void inorderpre(Node node, int val) {

		if (node == null)
			return;

		if (val == node.data) {

			if (node.left != null) {
				Node temp = node.left;
				while (temp.right != null) {
					temp = temp.right;
				}
				pre = temp;
			}
			return;

		}

		if (val < node.data) {
			inorderpre(node.left, val);
		}

		else {
			pre = node;
			inorderpre(node.right, val);
		}
	}

	public void inorderwithoutrecur() {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node temp = root;
		while (temp.left != null) {
			s.push(temp.left);
			temp = temp.left;
		}
		while (!s.empty()) {
			Node n = s.pop();
			System.out.println(n.data);
			if (n.right != null) {
				Node temp1 = n.right;
				s.push(temp1);
				while (temp1.left != null) {
					s.push(temp1.left);
					temp1 = temp1.left;
				}

			}
		}

		while (!s.empty())
			System.out.println(s.pop().data);
	}

	public void preptree(int l, int h, int[] a) {
		root = prtree(l, h, a);
	}

	public Node prtree(int l, int h, int[] a) {

		if (l <= h) {
			int mid = (l + h) / 2;
			Node n = new Node(a[mid]);

			n.left = prtree(l, mid - 1, a);
			n.right = prtree(mid + 1, h, a);
			return n;
		}
		return null;
	}

	private void isBST() {
		boolean i = isBST(root, 0, 1000);
		System.out.println(i);
	}

	public boolean isBST(Node node, int min, int max) {

		if (node == null)
			return true;
		if (node.data > min && node.data < max
				&& isBST(node.left, min, node.data)
				&& isBST(node.right, node.data, max))
			return true;
		else
			return false;

	}

	public void maxdepth() {
		int i = maxde(root);
		System.out.println(i);

	}

	public int maxde(Node node) {
		if (node == null)
			return 0;
		else
			return (1 + maxde(node.left) + maxde(node.right));
	}

	public int maxd(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(maxd(node.left), maxd(node.right));

	}

	public void cloneing() {
		printTree(root);
		Node newroot = clone(root);
		System.out.println();
		printTree(newroot);
		System.out.println("done");
	}

	public Node clone(Node node) {
		if (node == null)
			return null;
		Node newnode = new Node(node.data);
		if (node.left != null)
			newnode.left = clone(node.left);
		if (node.right != null)
			newnode.right = clone(node.right);

		return newnode;
	}

	public void finddia() {
		int k = finddia(root);
		System.out.println(k);
	}

	public int finddia(Node node) {
		if (node == null)
			return 0;
		int heightl = findheight(node.left);
		int heightr = findheight(node.right);
		int ldia = finddia(node.left);
		int rdia = finddia(node.right);
		return (Math.max(heightl + heightr + 1, Math.max(ldia, rdia)));
	}

	public int findheight(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(findheight(node.left), findheight(node.right));
	}

	public void minval() {
		int i = minval(root);
		System.out.println(i);
	}

	public int minval(Node node) {
		if (node == null)
			return 0;
		else if (node.left == null)
			return node.data;
		else
			return minval(node.left);
	}

	public void horizontalheight() {
		horizontal(root);
	}

	public void horizontal(Node node) {
		Stack<Node> one = new Stack<Node>();
		Stack<Node> two = new Stack<Node>();
		one.push(node);
		while (one.empty() || two.empty()) {
			if (one.empty() != true) {
				// System.out.println("ashish");
				while (one.empty() != true) {
					Node n = one.pop();
					System.out.print(n.data + " ");

					if (n.left != null)
						two.push(n.left);
					if (n.right != null)
						two.push(n.right);
				}
				System.out.println();
			}
			if (two.empty() != true) {
				while (two.empty() != true) {
					Node n = two.pop();
					System.out.print(n.data + " ");
					if (n.left != null)
						one.push(n.left);
					if (n.right != null)
						one.push(n.right);
				}
				System.out.println();
			}
		}

	}
	static int max =0;
	public void verticalheight() {
		HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
		vertical(root, 0, h, min, max);

		SortedSet<Integer> i = new TreeSet<Integer>(h.keySet());
		 for (int keys : i) {
		 System.out.println(h.get(keys)); }
	}

	public void vertical(Node node, int hd,
			HashMap<Integer, ArrayList<Integer>> h, int min, int max) {
		if (node == null)
			return;

		
		if (h.get(hd) == null) {
			System.out.println("initializing element for index " + hd
					+ " element " + node.data);
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(node.data);
			h.put(hd, list);
		} else {
			System.out.println("adding element " + node.data + " for index "
					+ hd);
			h.get(hd).add(node.data);
		}
		vertical(node.left, hd - 1, h, min, max);
		vertical(node.right, hd + 1, h, min, max);

	}

	public void hassum(int sum) {
		boolean i = hassum(root, sum);
		System.out.println(i);
	}

	public static int count = 0;

	public void printpaths() {
		int a[] = new int[100];

		printpaths(root, a, 0);
	}

	public void printpaths(Node node, int[] a, int length) {
		if (node == null)
			return;
		a[length] = node.data;
		length++;
		if (node.left == null && node.right == null) {
			for (int i = 0; i < length; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}
		printpaths(node.left, a, length);
		printpaths(node.right, a, length);
	}

	public void treetolist() {
		treetolist(root);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
		System.out.println();
		while (prev != null) {
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}

	static Node prev = null;
	static Node head = null;
	static Node tail = null;

	/*
	 * void flattenInorder(Node node) { if (node == null) return;
	 * flattenInorder(node.left); if (head == null) head = node; if (prev !=
	 * null) { prev.right = node; } node.left = null; prev = node;
	 * flattenInorder(node.right); }
	 */

	public void printsums() {
		int a[] = new int[20];

		printsums(root, a, 28, 0, 0);
	}

	public void printsums(Node node, int[] a, int target, int length, int sum) {
		if (node == null)
			return;
		a[length] = node.data;
		length++;
		sum = sum + node.data;
		if (sum == target) {
			for (int i = 0; i < length; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}
		printsums(node.left, a, target, length, sum);
		printsums(node.right, a, target, length, sum);
		printsums(node.left, a, target, 0, 0);
		printsums(node.right, a, target, 0, 0);
	}

	public void kthsmall() {
		kthsmall(root, 0);

	}

	public void kthsmall(Node node, int x) {
		if (node == null)
			return;

		else {
			kthsmall(node.left, x);
			x++;
			if (node.data >= 8 && node.data <= 25) {
				System.out.println(node.data);
			}
			kthsmall(node.right, x);
		}
	}

	void treetolist(Node node) {
		if (node == null)
			return;
		treetolist(node.left);
		if (head == null && prev == null) {
			head = node;
			head.right = null;
			head.left = null;
			prev = head;
		} else {
			prev.right = node;
			node.left = prev;
			prev = node;
		}
		treetolist(node.right);
	}

	public boolean hassum(Node node, int sum) {
		if (node == null)
			return (sum == 0);
		else
			sum = sum - node.data;
		return (hassum(node.left, sum) || hassum(node.right, sum));
	}

	public void printpath() {
		int[] paths = new int[20];
		printpath(root, paths, 0);

	}

	public void printpath(Node node, int[] path, int pathlength) {
		if (node == null)
			return;

		path[pathlength] = node.data;
		pathlength++;

		if (node.left == null && node.right == null) {
			printarray(path, pathlength);
		} else {
			printpath(node.left, path, pathlength);
			printpath(node.right, path, pathlength);
		}
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		if (node != null) {
			// do the sub-trees

			// swap the left/right pointers
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;

			mirror(node.left);
			mirror(node.right);

		}
	}

	public void levels() {
		ArrayList<ArrayList<Node>> a = levels(root);
		for (ArrayList<Node> l : a) {
			System.out.println();
			for (Node n : l) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Node>> levels(Node node) {
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		// Node current = node;
		ArrayList<Node> current = new ArrayList<Node>();
		current.add(node);
		list.add(current);

		while (current.size() > 0) {
			ArrayList<Node> parent = new ArrayList<Node>();
			parent = current;
			current = new ArrayList<Node>();
			for (Node n : parent) {
				if (n.left != null)
					current.add(n.left);
				if (n.right != null)
					current.add(n.right);
			}
			list.add(current);
		}

		return list;
	}

	public void printarray(int[] a, int l) {
		for (int i = 0; i < l; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree t = new tree();
		t.insert(11);
		t.insert(5);
		t.insert(15);
		t.insert(4);
		t.insert(9);
		t.insert(7);
		t.insert(13);
		t.insert(24);
		t.insert(18);
		// t.insert(9);
		t.insert(10);
		// t.insert(13);
		// t.insert(24);
		// t.insert(18);
		t.insert(12);
		t.insert(25);
		t.insert(26);
		t.insert(27);
		t.insert(28);
		// t.dfs();
		//int[] a = { 1, 3, 5, 8, 9, 10, 11, 15, 18, 25, 27, 56, 67, 89, 100 };
		//t.preptree(0,a.length-1,a);
		t.printTree();

		//t.levels();
		//t.maxdepth();

		// t.printleft();
		// t.cloneing();
		//t.printsums();
		// t.printleaf();
		//t.verticalheight();
		 //t.horizontalheight();
		// t.lca();
		// t.inorderpre();
		// t.inorderwithoutrecur();
		// t.kthsmall();
	//	t.height();
		 t.treetolist();
		// t.printpaths();
		System.out.println();
		// t.dfs();

		// t.finddia();
	}

}
