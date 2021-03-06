// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0


public class SearchInsertionPosition{
	// use binary search
	public int searchInsertion(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int start = 0;
		int end = nums.length-1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(nums[mid] == target){
				return mid;
			}
			else if(target < nums[mid]){
				end = mid - 1;
			}
			else{
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		SearchInsertionPosition sip = new SearchInsertionPosition();
		System.out.println(sip.searchInsertion(nums, 5));
		System.out.println(sip.searchInsertion(nums, 7));
		System.out.println(sip.searchInsertion(nums, 0));
	}
}
