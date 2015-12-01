// Given a string, find the length of the longest substring without repeating characters.
// For example, the longest substring without repeating letters for "abcabcbb" is "abc",
// which the length is 3.
// For "bbbbb" the longest substring is "b", with the length of 1.


import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters{
	public static int lengthOfLongestSubstring(String s){
		if(s == null || s.length() == 0){
			return 0;
		}

		char[] chars = s.toCharArray();
		int maxLen = 1;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<chars.length; i++){
			Integer lastOccurance = map.get(chars[i]);
			if(lastOccurance != null && lastOccurance >= start){
				maxLen = Math.max(maxLen, i - start);
				start = lastOccurance + 1;
			}
			map.put(chars[i], i);
		}
		maxLen = Math.max(maxLen, chars.length - start);
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
