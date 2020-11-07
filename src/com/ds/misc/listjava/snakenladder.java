package listjava;

import java.util.LinkedList;
import java.util.Queue;

class vertex {
	int v;
	int dist;

	vertex() {
		v = 0;
		dist = 0;
	}
}

public class snakenladder {

	public static int getMinDiceThrows(int[] moves, int n) {
		boolean[] visited = new boolean[30];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
		vertex v1 = new vertex();
		visited[0]=true;
		Queue<vertex> x = new LinkedList<vertex>();
		x.add(v1);
		
		while (!x.isEmpty()) {
			
			//visited[v2.v] = true;
			vertex v2 = x.remove();
			System.out.println(v2.v+" "+v2.dist);
			if (v2.v == n - 1) {
				System.out.println("ash");
				return v2.dist;			}

			for (int i = v2.v + 1; i <= v2.v + 6 && i < n; i++) {
				if(!visited[i])
				{
					//System.out.println(i);
				vertex v3 = new vertex();
				v3.dist = v2.dist + 1;
				visited[i] =true;
				if (moves[i] == -1) {
					v3.v = v2.v + 1;
				} else
					v3.v = moves[i];
				x.add(v3);
				}
			}
			

		}
		return 1;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 30;
		int moves[] = new int[30];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is "
				+ getMinDiceThrows(moves, N));

	}

}
