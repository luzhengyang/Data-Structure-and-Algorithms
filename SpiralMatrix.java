// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

import java.util.*;

public class SpiralMatrix{
	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return res;
		}

		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length-1;

		while(true){
			// 1. from left to right, move along top
			for(int j = left; j <= right; j++){
				res.add(matrix[top][j]);
			}
			top++;
			if(isOutOfBoundary(left, right, top, bottom)){
				break;
			}



			// 2. from top to bottom, move along right
			for(int i = top; i <= bottom; i++){
				res.add(matrix[i][right]);
			}
			right--;
			if(isOutOfBoundary(left, right, top, bottom)){
				break;
			}



			// 3. from right to left, move along bottom
			for(int j = right; j >= left; j--){
				res.add(matrix[bottom][j]);
			}
			bottom--;
			if(isOutOfBoundary(left, right, top, bottom)){
				break;
			}



			// 4. from bottom to top, move along left
			for(int i = bottom; i >= top; i--){
				res.add(matrix[i][left]);
			}
			left++;
			if(isOutOfBoundary(left, right, top, bottom)){
				break;
			}


		}

		return res;
	}

	private static boolean isOutOfBoundary(int left, int right, int top, int bottom){
		if(left > right || top > bottom){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		List<Integer> res = spiralOrder(matrix);
		for(int i=0; i<res.size(); i++){
			System.out.print(res.get(i) + " ");
		}
	}
}
