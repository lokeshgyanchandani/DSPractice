package miscellaneous;

import java.util.Scanner;
import java.util.Stack;

public class Validparentheses {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = new String(in.next());
		in.close();
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		if (s == null)
			return true;

		int len = s.length();

		if (len % 2 != 0)
			return false;

		Stack<Character> temp = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char x = s.charAt(i);
			if (x == '(' || x == '{' || x == '[' || x == '<')
				temp.push(x);
			else {
				if (temp.isEmpty())
					return false;
				char y = temp.pop();
				if ((x == ')' && y != '(') || (x == ']' && y != '[')
						|| (x == '}' && y != '{') || (x == '>' && y != '<')) {
					return false;
				}
			}
		}

		if (!temp.isEmpty())
			return false;
		else
			return true;
	}

}
