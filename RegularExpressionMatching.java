// Implement regular expression matching with support for '.' and '*'.

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true


public class RegularExpressionMatching{
	public boolean isMatch(String s, String p){
		boolean[] match = new boolean[s.length()+1];
		match[s.length()] = true;
		for(int i=p.length()-1; i>=0; i--){
			if(p.charAt(i) == '*'){
				for(int j=s.length()-1; j>=0; j--){
					match[j] = match[j] || match[j+1] && (p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j));
				}
				i--;
			}
			else{
				for(int j=0; j<s.length(); j++){
					match[j] = match[j+1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
				}
				match[s.length()] = false;
			}
		}
		return match[0];
	}

	public void test(){
		String s = "ab";
		String s2 = "aaa";
		String p = ".*";
		String p2 = "aa";
		System.out.println(isMatch(s, p));
		System.out.println(isMatch(s2, p2));
	}

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		rem.test();
	}
}
