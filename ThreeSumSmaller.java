// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]


public class ThreeSumSmaller{
	public static int threeSumSmaller(int[] nums, int target){
		if(nums == null || nums.length < 3){
			return 0;
		}

		Arrays.sort(nums);

	}
}
