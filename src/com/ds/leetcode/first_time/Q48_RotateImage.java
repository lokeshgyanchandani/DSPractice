package com.ds.leetcode.first_time;

public class Q48_RotateImage {

	void rotate(int[][] matrix) {

		/*
			It's a good method, but remember this is a high school geometry level problem.
			All rotations are composite reflections (in fact, all transformations are composite reflections);
			In this case, a reflection across the diagonal, then a reflection across the vertical line of symmetry.
			If you recall this fact, this method will allow you to swap in-place rather than having to
			endure the tedium of multiplying by a rotation matrix.
		*/

		//Swap all the rows
		int s = 0, e = matrix.length - 1;
		while(s < e){
			int[] temp = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++; e--;
		}

		//Transpose the matrix
		for(int i = 0; i < matrix.length; i++){
			for(int j = i + 1; j < matrix[i].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
