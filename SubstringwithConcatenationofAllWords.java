
import java.util.*;

public class SubstringwithConcatenationofAllWords{
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words == null || words.length == 0){
			return res;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<words.length; i++){
			if(!map.containsKey(words[i])){
				map.put(words[i], 1);
			}
			else{
				map.put(words[i], map.get(words[i])+1);
			}
		}

		int sLen = s.length();
		int wordLen = words[0].length();

		for(int i=0; i<=sLen - wordLen*words.length; i++){
			int start = i;
			int count = 0;
			String cur = s.substring(start, start+wordLen);
			while(map.containsKey(cur) && map.get(cur) > 0){
				map.put(cur, map.get(cur) - 1);
				count++;
				start = start + wordLen;
				if(start + wordLen > sLen){
					break;
				}
				cur = s.substring(start, start + wordLen);
			}

			if(count == words.length){
				res.add(i);
			}

			if(count > 0){
				map.clear();
				for(int j=0; j<words.length; j++){
					if(!map.containsKey(words[j])){
						map.put(words[j], 1);
					}
					else{
						map.put(words[j], map.get(words[j])+1);
					}
				}
			}
		}
		return res;
	}
}
