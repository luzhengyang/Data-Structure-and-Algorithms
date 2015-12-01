// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
//     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

//     A solution set is:
//     (-1,  0, 0, 1)
//     (-2, -1, 1, 2)
//     (-2,  0, 0, 2)

// 思路：在两层循环中做一个2sum

import java.util.*;

public class FourSum{
	public static List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(nums == null || nums.length == 0){
			return res;
		}

		Arrays.sort(nums);
		int len = nums.length;

		if(target < nums[0]*4 || target > nums[len-1]*4){
			return res;
		}

		for(int i=0; i<len-3; i++){
			if(i>0 && nums[i] == nums[i-1]){	// skip duplicates
				continue;
			}
			for(int j=i+1; j<len-2; j++){
				if(j>i+1 && nums[j] == nums[j-1]){	// skip duplicates
					continue;
				}
				// start 2sum
				int low = j+1;
				int high = len-1;
				while(low < high){
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if(sum == target){
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while(low < high && nums[low] == nums[low+1]){	// skip duplicates
							low++;
						}
						while(low < high && nums[high] == nums[high-1]){	// skip duplicates
							high--;
						}
						low++;
						high--;
					}
					else if(sum < target){
						low++;
					}
					else{
						high--;
					}
				}

			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> res = fourSum(nums, target);
		for(List l : res){
			for(int i=0; i<l.size(); i++){
				System.out.print(l.get(i));
			}
			System.out.println();
		}
	}
}
