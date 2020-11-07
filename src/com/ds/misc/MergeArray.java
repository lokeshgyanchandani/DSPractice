package miscellaneous;

public class MergeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 5, 7, 8, 10 };
		int b[] = {  };
		int c[] = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		if (i < a.length) {
			while (i < a.length)
				c[k++] = a[i++];
		} else {
			while (j < b.length)
				c[k++] = b[j++];
		}
		for (int l : c) {
			System.out.println(l);
		}
	}

}
