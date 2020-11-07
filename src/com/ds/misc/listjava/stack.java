package listjava;

class stacknode {
	int data;
	stacknode next;

	stacknode(int x) {
		data = x;
		next = null;
	}
}

public class stack {
	stacknode top = null;
	stacknode min = null;

	public void push(int x) {
		stacknode node = new stacknode(x);
		if (top == null) {
			top = node;
			min = node;
		} else {
			node.next = top;
			top = node;
			if (node.data < min.data) {
				node.next = min;
				min = node;
			}
		}
	}

	public void pop() {
		if (top != null) {
			top = top.next;
			if (min != null && top.data == min.data)
				min = min.next;
		} else
			System.out.println("stack empty");
	}

	public void min() {
		if (min != null)
			System.out.println(min.data);
		else
			System.out.println("no minimum");
	}

	public void print() {
		stacknode temp = top;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack s = new stack();
		s.push(6);
		s.push(5);
		s.min();
		s.push(3);
		s.push(4);
		s.push(2);
		s.min();
		s.push(6);
		// s.print();
		s.pop();
		s.pop();
		s.min();
		s.min();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.min();
		// s.print();

	}

}
