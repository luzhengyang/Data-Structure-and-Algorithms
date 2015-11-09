// Given a set of distinct integers, nums, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.


// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

import java.util.*;


public class Subsets{
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();
		dfs(nums, res, li, 0);
		return res;
	}

	public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> li, int index){
		res.add(new ArrayList<Integer>(li));
		for(int i=index; i<nums.length; i++){
			li.add(nums[i]);
			dfs(nums, res, li, i+1);
			li.remove(li.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> subsets = subsets(nums);
		for(List<Integer> li : subsets){
			System.out.println(li.toString());
		}
	}
}
