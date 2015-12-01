// Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

// For example, Given s = “eceba”,

// T is "ece" which its length is 3.



public class LongestSubstringwithAtMostTwoDistinctCharacters{
	public int lengthOfLongestSubstringTwoDistinct(String s){
		if(s == null || s.length() < 1){
			return 0;
		}
		int i = 0;
		int maxLen = 0;

		// use two pointers j, k to maintain a sliding window that only contains 2 distinct chars
		int j = -1;
		for(int k = 1; k < s.length(); k++){
			if(s.charAt(k) == s.charAt(k-1)){
				continue;
			}

			// we know that s.charAt(k) != s.charAt(k-1)
			if(j >= 0 && s.charAt(j) != s.charAt(k)){	// there are 3 disctinct chars in sliding window
				maxLen = Math.max(maxLen, (k - i));
				i = j + 1;	// make the sliding window have only 2 distinct chars
			}

			// we know that s.charAt(k) != s.charAt(k-1) && s.charAt(j) == s.charAt(k)
			j = k - 1;	// make j and k point to 2 different chars
		}

		// at last, k == s.length()
		return Math.max(maxLen, s.length() - i);

	}
}
