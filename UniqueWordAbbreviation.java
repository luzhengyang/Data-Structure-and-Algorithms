// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

// a) it                      --> it    (no abbreviation)

//      1
// b) d|o|g                   --> d1g

//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n

//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

// Example:
// Given dictionary = [ "deer", "door", "cake", "card" ]

// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true


import java.util.*;

public class UniqueWordAbbreviation{

	Map<String, String> map = new HashMap<String, String>();	// key is abbr, value is word

	public UniqueWordAbbreviation(String[] dictionary){	// constructor
		for(String word : dictionary){
			String s = abbr(word);
			if(!map.containsKey(s)){
				map.put(s, word);
			}
			else{
				if(!map.get(s).equals(word)){	// deals with the following situation:
					map.put(s, "");			// dictionary:["happy", "happy"] and isUnique("happy")
				}								// it should return true
			}
		}
	}

	public boolean isUnique(String word){
		String s = abbr(word);
		return map.size() == 0 || !map.containsKey(s) || map.get(s).equals(word);
	}

	private String abbr(String str){
		if(str == null || str.length() == 0){
			return "";
		}
		if(str.length() <= 2){
			return str;
		}
		return str.substring(0,1) + String.valueOf(str.length()-2) + str.substring(str.length()-1);
	}

	public static void main(String[] args) {
		String[] dictionary = {"happy", "happy", "deer", "door", "cake", "card"};
		UniqueWordAbbreviation uwa = new UniqueWordAbbreviation(dictionary);
		System.out.println(uwa.isUnique("happy"));	// should be true
		System.out.println(uwa.isUnique("dear"));	// should be false
		System.out.println(uwa.isUnique("cart"));	// should be true
		System.out.println(uwa.isUnique("cane"));	// should be false
		System.out.println(uwa.isUnique("make"));	// should be true
	}
}
