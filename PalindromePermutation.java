// Given a string, determine if a permutation of the string could form a palindrome.

// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.

// Consider the palindromes of odd vs even length.

// 解释：一个字符串内所有的字符是否能组合成一个回文字符串

import java.util.Set;
import java.util.HashSet;

public class PalindromePermutation{
	public static boolean canPermutePalindrome(String s){
		if(s==null){
			return false;
		}
		if(s.isEmpty()){
			return true;
		}

		Set<Character> set = new HashSet<Character>();

		for (int i=0; i<s.length(); i++) {
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
			}
			else {
				set.remove(s.charAt(i));
			}
		}

		return set.size()==1 || set.size()==0;
	}

	public static void main(String[] args) {
		String s1 = "code";
		String s2 = "aab";
		System.out.println(canPermutePalindrome(s1));
		System.out.println(canPermutePalindrome(s2));
	}
}
