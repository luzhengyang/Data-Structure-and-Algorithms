// Given n distinct positive integers, integer k (k <= n) and a number target.

// Find k numbers where sum is target. Calculate how many solutions there are?

// Example
// Given [1,2,3,4], k = 2, target = 5.

// There are 2 solutions: [1,4] and [2,3].

// Return 2.


// Dynamic Programming

public class KSum{
	public int kSum(int[] A, int k, int target){
		int[][][] dp = new int[A.length+1][k+1][target+1];
		// dp[i][j][t] means find j elements in i elements that sums to t

		for(int i=0; i<=A.length; i++){
			for(int j=0; j<=k; j++){
				for(int t=0; t<=target; t++){
					if(j == 0 && t == 0){//	find 0 element in i elements that sums to 0
						// the answer is always 1
						dp[i][j][t] = 1;
					}
					else if(!(i == 0 || j == 0 || t == 0)){
						dp[i][j][t] = dp[i-1][j][t];	// at least we have dp[i][j-1][t] results
						if(t - A[i-1] >= 0){
							// A[i-1] is the current number
							dp[i][j][t] += dp[i-1][j-1][t - A[i-1]];
						}
					}
				}
			}
		}
		return dp[A.length][k][target];

	}

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int k = 2;
		int target = 5;
		KSum ks = new KSum();
		System.out.println(ks.kSum(A, k, target));
	}
}
