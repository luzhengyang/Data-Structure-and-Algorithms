// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)

import java.util.*;

public class ThreeSum{
	public static List<List<Integer>> threeSum(int nums[]){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null || nums.length<3){
			return res;
		}
		Arrays.sort(nums);

		for(int i=0; i<nums.length-2; i++){
			if(i==0 || (i>0 && nums[i] != nums[i-1])){
				int low = i+1;
				int high = nums.length-1;
				int sumOfTwo = 0 - nums[i];
				while(low < high){
					if(nums[low] + nums[high] == sumOfTwo){
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while(nums[low] == nums[low+1]){
							low++;
						}
						while(nums[high] == nums[high-1]){
							high--;
						}
						low++;
						high--;
					}
					else if(nums[low] + nums[high] < sumOfTwo){
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
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);
		for(List<Integer> li : res){
			System.out.print("[");
			for(Integer i : li){
				System.out.print(" "+i);
			}
			System.out.println(" ]");
		}
	}
}
