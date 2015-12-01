// Determine if a Sudoku is valid

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

import java.util.*;

public class ValidSudoku{
	public boolean isValidSudoku(char[][] board){
		if(board == null || board.length==0 || board[0].length==0){
			return false;
		}

		for(int i=0; i<9; i++){
			Set<Character> set = new HashSet<Character>();
			for(int j=0; j<9; j++){
				if(board[i][j] != '.'){
					if(set.contains(board[i][j])){
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}

		for(int j=0; j<9; j++){
			Set<Character> set = new HashSet<Character>();
			for(int i=0; i<9; i++){
				if(board[i][j] != '.'){
					if(set.contains(board[i][j])){
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}

		for(int i=0; i<9; i+=3){
			for(int j=0; j<9; j+=3){
				Set<Character> set = new HashSet<Character>();
				for(int m=i; m<i+3; m++){
					for(int n=j; n<j+3; n++){
						if(board[i][j] != '.'){
							if(set.contains(board[m][n])){
								return false;
							}
							set.add(board[m][n]);
						}
					}
				}
			}
		}

		return true;
	}
}
