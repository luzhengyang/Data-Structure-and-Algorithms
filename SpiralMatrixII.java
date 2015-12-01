// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


public class SpiralMatrixII{
	public int[][] generateMatrix(int n){
		int[][] res = new int[n][n];
		if(n == 0){
			return res;
		}

		int left = 0;
		int right = n-1;
		int top = 0;
		int bottom = n-1;
		int num = 1;

		while(true){
			// 1. from left to right, along top
			for(int j=left; j<=right; j++){
				res[top][j] = num;
				num++;
			}
			top++;
			if(left > right || top > bottom){
				break;
			}

			// 2. from top to bottom, along right
			for(int i=top; i<=bottom; i++){
				res[i][right] = num;
				num++;
			}
			right--;
			if(left > right || top > bottom){
				break;
			}

			// 3. from right to left, along bottom
			for(int j=right; j>=left; j--){
				res[bottom][j] = num;
				num++;
			}
			bottom--;
			if(left > right || top > bottom){
				break;
			}

			// 4. from bottom to top, along left
			for(int i=bottom; i>=top; i--){
				res[i][left] = num;
				num++;
			}
			left++;
			if(left > right || top > bottom){
				break;
			}
		}
		return res;
	}
}
