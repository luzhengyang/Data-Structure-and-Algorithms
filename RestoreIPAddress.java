// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


import java.util.*;

public class RestoreIPAddress{
	public List<String> restoreIPAddress(String s){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() < 4){	// 0.0.0.0
			return res;
		}
		dfs(s, 0, 0, "", res);
		return res;
	}

	private void dfs(String s, int start, int count, String res, List<String> result){
		if(count == 3){
			String sub = s.substring(start, s.length());
			if(isValid(sub)){
				result.add(res + sub);
			}
		}

		for(int i = start + 1; i < s.length() && i <= start + 3; i++){
			String sub = s.substring(start, i); // from s.substring(0, 1)
			if(isValid(sub)){
				dfs(s, i, count+1, res+sub+".", result);
			}
		}
	}

	private boolean isValid(String s){
		// "255", "0" are valid
		if(s == null || s.length() == 0 || s.startsWith("0") && s.length() > 1){
			return false;
		}
		int result = 0;
		for(char c : s.toCharArray()){
			result = result * 10 + c - '0';
		}
		return result >=0 && result <= 255;
	}

	public void test(){
		String s = "25525511135";
		List<String> res = restoreIPAddress(s);
		for(String str : res){
			System.out.print(str+" ");
		}
	}

	public static void main(String[] args) {
		RestoreIPAddress ria = new RestoreIPAddress();
		ria.test();
	}
}
