// Numbers can be regarded as product of its factors. For example,

// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.

// Note:
// Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.
// Examples:
// input: 1
// output:
// []
// input: 37
// output:
// []
// input: 12
// output:
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
// input: 32
// output:
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]


import java.util.*;

public class FactorCombinations{
	public static List<List<Integer>> getFactors(int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, new ArrayList<Integer>(), 2, n);
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> list, int start, int n){
		if(n <= 1){
			if(list.size() > 1){
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for(int i = start; i <= n; i++){
			if(n % i == 0){
				list.add(i);
				dfs(res, list, i, n/i);
				list.remove(list.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 32;
		List<List<Integer>> res = getFactors(n);
		for(List<Integer> list : res){
			for(int i=0; i<list.size(); i++){
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}
