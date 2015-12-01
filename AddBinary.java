// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".



public class AddBinary{
	public String addBinary(String a, String b){
		if(a == null || b == null || a.length() == 0 || b.length() == 0){
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;

		int carry = 0;

		while(i >= 0 || j >= 0){
			int sum = carry;
			if(i >= 0){
				sum += a.charAt(i) - '0';
				i--;
			}
			if(j >= 0){
				sum += b.charAt(j) - '0';
				j--;
			}
			sb.insert(0, sum%2);
			carry = sum/2;
		}
		if(carry != 0){
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	public void test(){
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		ab.test();
	}
}
