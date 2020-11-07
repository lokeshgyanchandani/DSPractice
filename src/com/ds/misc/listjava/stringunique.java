package listjava;

public class stringunique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "abcabcdbb";
		int x = lengthOfLongestSubstring(str);
		System.out.println(x);
	}
	public static int lengthOfLongestSubstring(String s) {
		  int n = s.length();
		  int i = 0, j = 0;
		  int maxLen = 0;
		 boolean exist[] = new boolean[256];
		  while (j < n) {
		    if (exist[s.charAt(j)]==true) {
		      maxLen = Math.max(maxLen, j-i);
		      while (s.charAt(i) != s.charAt(j)) {
		        exist[s.charAt(i)] = false;
		        i++;
		      }
		      i++;
		      j++;
		    } else {
		      exist[s.charAt(j)] = true;
		      j++;
		    }
		  }
		  maxLen = Math.max(maxLen, n-i);
		  return maxLen;
		}

}
