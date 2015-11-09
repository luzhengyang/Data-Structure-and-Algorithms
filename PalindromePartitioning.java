import java.util.*;

public class PalindromePartitioning{

	List<List<String>> result = new ArrayList<List<String>>();

	public static void main(String[] args) {

	}

	public boolean isPalindrome(String s){
		int left = 0;
		int right = s.length()-1;
		while(left <= right){
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public void helper(String s, List<String> list){
		if (s.isEmpty()) {
			result.add(list);
		}
		for (int i=0; i<s.length(); i++) {
			String sub = s.substring(0,i+1);
			if (isPalindrome(sub)) {
				List<String> newList = new ArrayList<String>(list);
				newList.add(sub);
				helper(s.substring(i+1,s.length()), newList);
			}
		}
	}

	public List<List<String>> partition(String s){
		helper(s, new ArrayList<String>());
		return result;
	}
}
