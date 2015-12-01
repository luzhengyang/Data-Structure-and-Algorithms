// Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

import java.util.List;
import java.util.ArrayList;

public class MissingRanges{
	public static List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> res = new ArrayList<String>();

		if(nums == null){
			return res;
		}
		int next = lower; 	// next is the next number we are going to find
		for(int i=0; i<nums.length; i++){
			if(nums[i] < next){	// out of range
				continue;
			}
			if(nums[i] == next){	// not missing number
				next++;
				continue;
			}

			// now we know that nums[i] > next; next is the first missing number, nums[i]-1 is the last missing range
			res.add(getRange(next, nums[i]-1));

			next = nums[i] + 1;		// make next the next number of a[i], which is the start of a new range
		}

		// next is [last number of nums]+1
		if(next <= upper){
			res.add(getRange(next, upper));
		}

		return res;
	}

	private static String getRange(int m, int n){
		if(m == n){
			return String.valueOf(m);
		}
		else{
			return String.valueOf(m) + "->" + String.valueOf(n);
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 0;
		int upper = 99;
		List<String> res = findMissingRanges(nums, lower, upper);
		for(String s : res){
			System.out.println(s);
		}
	}
}
