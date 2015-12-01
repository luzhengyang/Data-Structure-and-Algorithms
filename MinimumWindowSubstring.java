// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".


import java.util.*;

public class MinimumWindowSubstring{
	public static String minWindow(String s, String t){
		if(s == null | t == null || s.length() == 0 || t.length() == 0){
			return "";
		}

		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		for(int i=0; i<t.length(); i++){
			if(!tMap.containsKey(t.charAt(i))){
				tMap.put(t.charAt(i), 1);
			}
			else{
				tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
			}
		}

		int start = 0;	// start position of the minimum window
		int end = 0;	// end position of the minimum window
		Map<Character, Integer> foundInS = new HashMap<Character, Integer>();
		int found = 0;	// number of times of the character found in s
		int minLen = Integer.MAX_VALUE;
		String minWindow = "";

		while(end < s.length()){
			char c = s.charAt(end);
			// First, find the end position
			if(tMap.containsKey(c)){
				if(!foundInS.containsKey(c)){
					foundInS.put(c, 1);
					found++;
				}
				else{	// c is in the foundInS
					if(foundInS.get(c) < tMap.get(c)){
						found++;
					}
					foundInS.put(c, foundInS.get(c) + 1);
				}
			}
			if(found == t.length()){
				// Second, find the start position
				char sc = s.charAt(start);
				while(!tMap.containsKey(sc) || foundInS.get(sc) > tMap.get(sc)){
					if(tMap.containsKey(sc) && foundInS.get(sc) > tMap.get(sc)){
						foundInS.put(sc, foundInS.get(sc) - 1);
					}
					start++;
					sc = s.charAt(start);
				}
				if(end - start + 1 < minLen){
					minLen = end - start + 1;
					minWindow = s.substring(start, end+1);
				}
			}
			end++;
		}
		return minWindow;
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(minWindow(S, T));
	}
}
