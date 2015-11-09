// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// Since the runtime complexity is O(log n), we should use binary search.

public class SearchForARange{

	public static int[] searchRange(int[] nums, int target){
		int first = -1;
		int last = -1;
		int start = 0;
		int end = nums.length-1;
		int[] result = {-1, -1};

		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] < target){
				start = mid + 1;
			}
			else if(target < nums[mid]){
				end = mid - 1;
			}
			else{
				end = mid - 1;
				first = mid;
			}
		}
		if(first == -1){
			return result;
		}

		start = 0;
		end = nums.length-1;

		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] < target){
				start = mid + 1;
			}
			else if(target < nums[mid]){
				end = mid - 1;
			}
			else{
				start = mid + 1;
				last = mid;
			}
		}

		result[0] = first;
		result[1] = last;
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] result = searchRange(nums, target);
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
