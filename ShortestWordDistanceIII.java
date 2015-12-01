// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// word1 and word2 may be the same and they represent two individual words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.


import java.util.*;

public class ShortestWordDistanceIII{
	public static int shortestWordDistance(String[] words, String word1, String word2){
		if(words == null || words.length < 2){
			return 0;
		}
		// map saves (word, index list)
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for(int i=0; i<words.length; i++){
			if(!map.containsKey(words[i])){
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(words[i], list);
			}
			else{
				map.get(words[i]).add(i);
			}
		}
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<list1.size(); i++){
			for(int j=0; j<list2.size(); j++){
			    int dist = Math.abs(list1.get(i) - list2.get(j));
			    if(dist != 0){
			        min = Math.min(min, dist);
			    }
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "makes";
		System.out.println(shortestWordDistance(words, word1, word2));
	}
}
