// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

import java.util.*;

public class NQueensII{
	private static int count;
	private static Set<Integer> col;
	private static Set<Integer> diag1;
	private static Set<Integer> diag2;

	public static int totalNQueens(int n){
		if(n == 0){
			return 0;
		}

		count = 0;
		col = new HashSet<Integer>();
		diag1 = new HashSet<Integer>();
		diag2 = new HashSet<Integer>();

		dfs(n, 0, new ArrayList<String>());

		return count;
	}

	private static void dfs(int n, int row, List<String> list){
		if(row == n){
			count++;
		}

		for(int i=0; i<n; i++){
			if(col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)){
				continue;
			}
			char[] arr = new char[n];
			Arrays.fill(arr, '.');
			arr[i] = 'Q';
			String str = new String(arr);
			list.add(str);
			col.add(i);
			diag1.add(row+i);
			diag2.add(row-i);
			dfs(n, row+1, list);
			list.remove(str);
			col.remove(i);
			diag1.remove(row+i);
			diag2.remove(row-i);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(totalNQueens(n));
	}
}
