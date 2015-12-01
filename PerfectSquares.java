// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

import java.util.*;

public class PerfectSquares{

	// return number of suqare numbers that sum to n
	public int numSquares(int n){
		int[] dp = new int[n+1];	// dp[n] means number of square numbers that sum to n
		Arrays.fill(dp, Integer.MAX_VALUE);		// DON'T forget this step!!!
		for(int i=0; i*i<n; i++){
			dp[i*i] = 1;	// number of square numbers that sum to a suqare number is 1
		}

		for(int a=0; a<=n; a++){
			for(int b=0; a + b*b<=n; b++){
				dp[a + b*b] = Math.min(dp[a] + 1, dp[a + b*b]);
			}
		}
		return dp[n];
	}

	public void test(){
		int n = 13;
		int res = numSquares(n);
		System.out.println(res);
	}

	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		ps.test();
	}
}
