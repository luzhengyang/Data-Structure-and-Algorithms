// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Return:

// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]


import java.util.*;

public class GroupShiftedStrings{
	public List<List<String>> groupStrings(String[] strings){
		List<List<String>> res = new ArrayList<List<String>>();
		if(strings == null || strings.length == 0){
			return res;
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for(String word : strings){
			String key = "";
			int offset = word.charAt(0) - 'a';
			for(int i=0; i<word.length(); i++){
				key += (word.charAt(i) - offset + 26) % 26;
			}
			if(!map.containsKey(word)){
				List list = new ArrayList<String>();
				list.add(word);
				map.put(key, list);
			}
			else{
				map.get(key).add(word);
			}
		}

		for(List<String> list : map.values()){
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
}
