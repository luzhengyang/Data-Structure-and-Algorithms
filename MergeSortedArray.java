public class MergeSortedArray{

	public static void merge(int[] A, int m, int[] B, int n){
		// m is the length of A and n is the length of B

		while (m>0 && n>0){
			if (A[m-1] > B[n-1]) {
				A[m+n-1] = A[m-1];
				m--;
			}
			else {
				A[m+n-1] = B[n-1];
				n--;
			}
		}

		while (n>0){
			A[m+n-1] = B[n-1];
			n--;
		}
	}

	public static void main(String[] args) {
		int[] A = new int[20];
		int[] B = new int[5];
		A[0] = 2;
		A[1] = 3;
		A[2] = 4;
		A[3] = 5;
		B[0] = -2;
		B[1] = -1;
		B[2] = 0;
		B[3] = 7;
		merge(A, 4, B, 4);
		for(int i=0; i<A.length; i++){
			System.out.println(A[i]+" ");
		}
	}
}
