// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1



// 1. from right to left, find the first number that violates the increase trend, and mark it as PartitionNumber
// 2. from right to left, find the first number that is larger than PartitionNumber, and mark it as ChangeNumber
// 3. swap PartitionNumber and ChangeNumber
// 4. reverse all numbers on the right of PartitionNumber

public class NextPermutation{
	public static void nextPermutation(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}

		for(int i=nums.length-2; i>=0; i--){
			if(nums[i] < nums[i+1]){
				int j = nums.length-1;
				for(; j>i; j--){
					if(nums[j] > nums[i]){
						break;
					}
				}
				swap(nums, i, j);
				reverse(nums, i+1);
				return;
			}
		}
		reverse(nums, 0);
		return;
	}

	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int start){
		int end = nums.length-1;
		while(start < end){
			swap(nums, start, end);
			end--;
			start++;
		}
	}

	public static void main(String[] args) {
		int[] nums = {6, 8, 7, 4, 3, 2};
		nextPermutation(nums);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]);
		}
	}
}
