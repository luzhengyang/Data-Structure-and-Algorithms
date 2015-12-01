// Given a digit string, return all possible letter combinations that the number could represent.

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.util.*;

public class LetterCombinationsofaPhoneNumber{

	private static final String[] LETTERS={
		"",		// 0
		"",		// 1
		"abc",	// 2
		"def",	// 3
		"ghi",	// 4
		"jkl",	// 5
		"mno",	// 6
		"pqrs",	// 7
		"tuv",	// 8
		"wxyz"	// 9
	};

	public List<String> letterCombinations(String digits){
		List<String> res = new ArrayList<String>();
		if(digits == null || digits.length() == 0){
			return res;
		}
		helper(digits, "", 0, res);
		return res;
	}

	// for backtracking
	private static void helper(String digits, String combo, int i, List<String> res){
		if(i == digits.length()){
			res.add(combo);
			return;
		}

		String letters = LETTERS[digits.charAt(i) - '0'];
		for(int j = 0; j<letters.length(); j++){
			helper(digits, combo+letters.charAt(j), i+1, res);
		}
	}
}
