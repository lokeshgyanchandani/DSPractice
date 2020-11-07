package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomIterable<Object> implements Iterable<Object> {

	static List list = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		list.add(1);
		list.add("abc");
		list.add(3);
		list.add("de");
		list.add(4);
//		for( java.lang.Object x:list)
//		{
//			System.out.println(x.toString());
//		}

		Iterator x = new MyIterator<>();
		while (x.hasNext()) {
			java.lang.Object a = x.next();
			if (a instanceof String)
				System.out.println(a);
		}

	}

	@Override
	public Iterator<Object> iterator() {
		return new MyIterator<Object>();
	}

	static class MyIterator<Object> implements Iterator<Object> {
		int index = 0;

		@Override
		public boolean hasNext() {
			if (index >= list.size()) {
				return false;
			}
			return true;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object next() {
			return (Object) list.get(index++);
		}

	}

}
