import java.util.Stack;

public class ValidParentheses{
	public static void main(String[] args) {
		String str1 = "(}{)";
		boolean result1 = ValidParentheses.isValid(str1);
		System.out.println(result1);

		String str2 = "({})";
		boolean result2 = ValidParentheses.isValid(str2);
		System.out.println(result2);
	}

	public static boolean isValid(String str){
		if (str.length() == 0 || str.length() == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || 
				str.charAt(i) == '{') {
				stack.push(str.charAt(i));

			}
			else {
				// no left parenthesis
				if (stack.size() == 0) {
					return false;
				}

				char top = stack.pop();
				if (str.charAt(i) == ')' && top != '(') {
					return false;
				}
				else if (str.charAt(i) == ']' && top != '[') {
					return false;
				}
				else if (str.charAt(i) == '}' && top != '{') {
					return false;
				}
			}
		}
		// if stack is empty, all parentheses are valid
		return stack.size() == 0;
	}
}