package interview;


public class AddParentheses {

	static void ParCheck(char[] c, int index,int left, int right, String str) {
		if (left == 0 && right == 0) {
			System.out.println(str);
		}

		if (left > 0 && (Integer.valueOf(c[index])<9)){
			ParCheck(c,index+1,left - 1, right + 1, str + "(");
		}
		if (right > 0) {
			ParCheck(c,index+1,left, right - 1, str + ")");
		}

	}

	public static void main(String[] args) {
		int num = 3;
		String st ="2*3-4*5";
		char[] c = st.toCharArray();
		String str = "";
		ParCheck(c,0, num, 0, str);
	}
}