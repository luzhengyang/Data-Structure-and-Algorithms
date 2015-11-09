// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class NumberOf1Bits{
	public static int number1Bits(int n){
		int count = 0;
		while(n != 0){
			if((n&1) == 1){
				// 如果是奇数
				count++;
			}
			n = n>>>1; // 右移一位
		}
		return count;
	}

	public static void main(String[] args) {
		int number = 11;
		System.out.println(number1Bits(number));
	}
}
