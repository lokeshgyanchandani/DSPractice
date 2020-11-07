package listjava;
import java.util.LinkedList;
public class linksample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> s = new LinkedList<>();
		s.addLast(5);
		s.addLast(6);
		s.addLast(7);
		int i = s.getFirst();
		System.out.println(i);
	}

}
