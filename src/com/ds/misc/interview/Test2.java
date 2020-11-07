package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Test1 {
	Test1(int x) {
		System.out.println("Constructor called " + x);
	}
}

// This class contains an instance of Test1
public class Test2 {
	Test1 t1 = new Test1(10);

	Test2(int i) { t1 = new Test1(i); }

	public static void main(String[] args) {
		Test2 t2 = new Test2(5);
		Set<Integer> list = new HashSet<>(Arrays.asList(1));
		System.out.println(list.size());
	}
}