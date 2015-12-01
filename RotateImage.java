// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?


public class RotateImage{
	public static void rotate(int[][] matrix){
		// get the transpose of the matrix
		// reverse every row of the transpose
		// it's done!

		if(matrix == null || matrix.length == 0){
			return;
		}

		int n = matrix.length;

		// get the transpose
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// reverse the transpose
		for(int j=0; j<n; j++){
			reverse(matrix[j], 0, n-1);
		}

		return;


	}

	private static void reverse(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 6}, {4, 3, 7}, {0, 10, 11}};
		rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}
}
