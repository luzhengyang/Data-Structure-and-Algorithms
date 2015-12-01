// The gray code is a binary numeral system where two successive values differ in only one bit.

// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.

// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

// For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


import java.util.*;

public class GrayCode{
	public List<Integer> grayCode(int n){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<Math.pow(2, n); i++){
			res.add((i>>1)^i);
		}
		return res;
	}

	public void test(){
		int n = 2;
		List<Integer> res = grayCode(n);
		for(Integer i : res){
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		gc.test();
	}
}
