package listjava;

import java.util.ArrayList;

public class LCsub {

	public static int cost(char[] x, char[] y) {
		
		int m = x.length + 1;
		int n = y.length + 1;
		int max=0,maxI=0,maxJ=0;
			
		int index1=0,index2 =0;
		ArrayList<Character> list = new ArrayList<Character>();
		int a[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			a[i][0] = 0;
		}

		for (int i = 0; i < n; i++) {
			a[0][i] = 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (x[i - 1] == y[j - 1])
					a[i][j] = a[i - 1][j - 1] + 1;
				else
					a[i][j] = 0;
				if (a[i][j] > max)
				{
					max = a[i][j];
					maxI=i;
					maxJ=j;
				}
			
			}
		}
		
		System.out.println("index1"+maxI);
		System.out.println("index2"+maxJ);
		
		for (int i=0;i<max;i++)
		{
			System.out.println(x[maxI-maxJ+i]);
		}
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		for(char t :list){
			System.out.print(t);
		}
		return a[m - 1][n - 1];
	}

	
//	int LCSubStr(char *X, char *Y, int m, int n)
//	{
//	    // Create a table to store lengths of longest common suffixes of
//	    // substrings.   Notethat LCSuff[i][j] contains length of longest
//	    // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
//	    // first column entries have no logical meaning, they are used only
//	    // for simplicity of program
//	    int LCSuff[m+1][n+1];
//	    int result = 0;  // To store length of the longest common substring
//	 
//	    /* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
//	    for (int i=0; i<=m; i++)
//	    {
//	        for (int j=0; j<=n; j++)
//	        {
//	            if (i == 0 || j == 0)
//	                LCSuff[i][j] = 0;
//	 
//	            else if (X[i-1] == Y[j-1])
//	            {
//	                LCSuff[i][j] = LCSuff[i-1][j-1] + 1;
//	                result = max(result, LCSuff[i][j]);
//	            }
//	            else LCSuff[i][j] = 0;
//	        }
//	    }
//	    return result;
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x1 = "hellogo";
		String y1 = "alogha";
		char[] x = x1.toCharArray();
		char[] y = y1.toCharArray();
		int k = cost(x, y);
		System.out.println(k);
	}

}
