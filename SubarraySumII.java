// Given an integer array, find a subarray where the sum of numbers is between two given interval.
// Your code should return the number of possible answer. (The element in the array should be positive)

// Example
// Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

// [0, 0]
// [0, 1]
// [1, 1]
// [2, 2]


import java.util.*;

public class SubarraySumII{
	public int subarraySumII(int[] A, int start, int end) {
        // Write your code here

        if(A == null || A.length == 0){
            return 0;
        }

        int count = 0;

        for(int i=0; i<A.length; i++){
            int sum = 0;
            for(int j=i; j<A.length; j++){
                sum += A[j];
                if(start <= sum && sum <= end){
                	System.out.println(A[j]);
                    count++;
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		SubarraySumII ss = new SubarraySumII();
		int count = ss.subarraySumII(A, 1, 3);
	}
}
