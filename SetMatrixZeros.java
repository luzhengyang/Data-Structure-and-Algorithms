public class SetMatrixZeros{
	public static void main(String[] args) {

	}

	public static void setZeroes(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;

		if(m==0 || n==0){
			return;
		}

		int[] flagrow = new int[m];
		int[] flagcolumn = new int[n];

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (matrix[i][j] == 0) {
					flagrow[i] = 1;
					flagcolumn[j] = 1;
				}
			}
		}

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (flagrow[i]==1 || flagcolumn[j]==1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
