public class ReverseWordsinaStringII{
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        reverse(s, 0, s.length-1);  // reverse the all words

        // reverse each word when we encounter a space or j is after end of the string
        int i = 0;
        for(int j = 0; j<s.length+1; j++){
            if(j == s.length || s[j] == ' '){
                reverse(s, i, j-1);
                i = j + 1;
            }
        }
    }

    public static void reverse(char[] s, int start, int end){
        for(int i = 0; i <= (end - start)/2; i++){
            char temp = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = temp;
        }
    }

    public static void main(String[] args) {
    	char[] s = {'h','e','l','l','o',' ','w','o','r','l','d','!'};
    	reverse(s, 0, s.length-1);
    	for(char c : s){
    		System.out.print(c);
    	}
    }
}
