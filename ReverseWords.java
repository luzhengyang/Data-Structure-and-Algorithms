// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

public class ReverseWords{
	public static String reverseWords(String s){
		if(s==null || s.length()<1){
			return "";
		}
		String[] words = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i=words.length-1; i>=0; i--){
			if(!words[i].equals("")){
				sb.append(words[i]).append(" ");
			}
		}
		if(sb.length()==0){
			return "";
		}
		else{
			return sb.substring(0, sb.length()-1);
		}
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}
