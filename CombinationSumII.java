// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8,
// A solution set is:
// [1, 7]
// [1, 2, 5]
// [2, 6]
// [1, 1, 6]

import java.util.*;

public class CombinationSumII{
	public static List<List<Integer>> combinationsSumII(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		Arrays.sort(candidates);	// DONT FORGOT SORT!!!!
		dfs(candidates, target, 0, new ArrayList<Integer>(), res);
		return res;
	}

	private static void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res){
		if(target == 0){
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for(int i=start; i<candidates.length; i++){
			int newTarget = target - candidates[i];
			if(newTarget >= 0){
				list.add(candidates[i]);
				dfs(candidates, newTarget, i+1, list, res);
				list.remove(list.size()-1);
			}
			else{
				break;
			}

			while(i < candidates.length - 1 && candidates[i] == candidates[i+1]){
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = combinationsSumII(nums, target);
		for(List<Integer> list : res){
			for(int i=0; i<list.size(); i++){
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
}
