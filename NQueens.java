// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]

import java.util.*;

public class NQueens{
	private static Set<Integer> col = new HashSet<>();
	private static Set<Integer> diag1 = new HashSet<>();
	private static Set<Integer> diag2 = new HashSet<>();

	public static List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		if(n == 0){
			return res;
		}
		dfs(res, new ArrayList<String>(), 0, n);
		return res;
	}

	public static void dfs(List<List<String>> res, List<String> list, int row, int n){
		if(row == n){
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int i=0; i<n; i++){
			if(col.contains(i) || diag1.contains(row+i) || diag2.contains(row-i)){
				continue;
			}
			char[] chars = new char[n];
			Arrays.fill(chars, '.');
			chars[i] = 'Q';
			String str = new String(chars);

			list.add(str);
			col.add(i);
			diag1.add(row+i);
			diag2.add(row-i);

			dfs(res, list, row+1, n);

			list.remove(str);
			col.remove(i);
			diag1.remove(row+i);
			diag2.remove(row-i);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> res = solveNQueens(n);
		for(List<String> list : res){
			for(int i=0; i<list.size(); i++){
				System.out.print(list.get(i)+",");
			}
			System.out.println();
		}
	}
}
