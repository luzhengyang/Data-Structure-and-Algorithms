// 给你一个二维字母的数组，可以上下左右走，查找是否某个单词是否存在。
// 同一位置的字母不可以被使用多次，所以要记录该字母是否用过。

public class WordSearch{


	public static boolean exist(char[][] board, String word){

		if(board == null || board.length == 0 || board[0].length == 0 || word == null){
			return false;
		}
		if(word.length() == 0){
			return true;
		}

		boolean[][] vistited = new boolean[board.length][board[0].length];

		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(word.charAt(0)==board[i][j] && search(board, word, i, j, 0, vistited)){
					return true;
				}
			}
		}
		return false;

	}

	public static boolean search(char[][] board, String word, int i, int j, int index, boolean[][] vistited){
		if(index == word.length()){
			return true;
		}

		if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index)!=board[i][j] || vistited[i][j]){
			return false;
		}

		vistited[i][j] = true;

		if(search(board, word, i+1, j, index+1, vistited) ||
			search(board, word, i-1, j, index+1, vistited) ||
			search(board, word, i, j+1, index+1, vistited) ||
			search(board, word, i, j-1, index+1, vistited)){
			return true;
		}

		vistited[i][j] = false;
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E' ,'E'}
        };
        // String word = "SEE";
        // String word = "ABCCED";
        String word = "ABCB";
        System.out.println(exist(board, word));
	}
}
