// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.

import java.util.*;

public class MultiplyStrings{
	public static String multiply(String num1, String num2){
		if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
			return "";
		}

		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}

		int m = num1.length();
		int n = num2.length();

		int[] products = new int[m+n];

		for(int i=m-1; i>=0; i--){
			for(int j=n-1; j>=0; j--){
				int a = num1.charAt(i) - '0';
				int b = num2.charAt(j) - '0';
				products[i+j+1] = products[i+j+1] + a*b;
			}
		}

		int carry = 0;
		for(int i=products.length-1; i>=0; i--){
			int k = (products[i] + carry) % 10;
			carry = (products[i] + carry) / 10;
			products[i] = k;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<products.length; i++){
			sb.append(products[i]);
		}
		while(sb.length() != 0 && sb.charAt(0) == '0'){
			sb.deleteCharAt(0);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "32423";
		String num2 = "2324523";
		System.out.println(multiply(num1, num2));

	}
}
