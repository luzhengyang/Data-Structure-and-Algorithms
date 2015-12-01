// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.


public class SearchinRotatedSortedArray{
	public static int search(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		int left = 0;
		int right = nums.length-1;

		while(left <= right){
			int mid = left + (right-left)/2;
			if(target == nums[mid]){
				return mid;
			}
			else if(nums[mid] >= nums[left]){
				if(nums[left] <= target && target < nums[mid]){
					right = mid-1;
				}
				else{
					// target > nums[mid]
					left = mid+1;
				}
			}
			else{
				// nums[mid] > nums[left]
				if(nums[mid] < target && target <= nums[right]){
					left = mid+1;
				}
				else{
					// target < nums[mid]
					right = mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(nums, 0));
	}
}
