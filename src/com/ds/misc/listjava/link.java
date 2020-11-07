package listjava;

class nnode {
	int data;
	nnode nextnnode;

	public nnode(int data) {
		this.data = data;
	}
}

public class link {
	nnode head;
	nnode tail;

	nnode dummy;

	public void add(nnode newnnode) {
		if (tail == null) {
			head = newnnode;
			tail = newnnode;
		} else {
			tail.nextnnode = newnnode;
			tail = newnnode;
		}
	}

	public void print() {
		while (head != null) {
			System.out.println(head.data);
			head = head.nextnnode;

		}
	}

	public static void main(String[] args) {
		link mylist = new link();
		mylist.add(new nnode(12));
		mylist.add(new nnode(13));
		mylist.print();
		// dummy = head;
		// while(dummy != NULL)
		// {
		// System.out.println("MYLIST: "+dummy.data);
		// }

	}

}