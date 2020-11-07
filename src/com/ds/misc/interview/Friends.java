package interview;

public class Friends {

	public static void main(String[] args) {
		String[] ar = { "YYNN", "YYYN", "NYYN", "NNNY" };
		int n = ar.length;
		char[][] mat = new char[n][n];
		int h = 0;
		while (h < n) {
			String temp = ar[h];
			for (int j = 0; j < n; j++)
				mat[h][j] = temp.charAt(j);
			h++;
		}
		
		int count = 0;
		boolean visited[][] = new boolean[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<mat[i].length;j++){
				if(mat[i][j]=='Y' && visited[i][j]==false){
				count++;
				exploreN(mat,visited,i,j);
				}
			}
		System.out.println(count);
	}
	
	public static void exploreN(char[][] matrix, boolean[][] visited, int i, int j)
	{
		visited[i][j]=true;;
		
		for(int k =0;k<matrix[0].length;k++){
			if(matrix[j][k]=='Y' && visited[i][k]==false)
				exploreN(matrix,visited,j, k);
			visited[j][k] = true;
		}
	}
		
		
}

	

