// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

// 要构成Strobogrammatic Number, 必定是中心对称

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber{
	public static boolean isStrobogrammatic(String num){
		if(num==null || num.length()<1){
			return false;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');

		int start = 0;
		int end = num.length()-1;

		while(start <= end){
			if(!map.containsKey(num.charAt(start))){
				return false;
			}
			if(map.get(num.charAt(start)) != num.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "818";
		String s2 = "69";
		String s3 = "696";
		System.out.println(isStrobogrammatic(s1));
		System.out.println(isStrobogrammatic(s2));
		System.out.println(isStrobogrammatic(s3));
	}
}
