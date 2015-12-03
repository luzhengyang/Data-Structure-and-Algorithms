// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.


import java.util.*;

public class PermutationSequence{
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
        	list.add(i+1);
        }
        // int fac = factorial(n);

        k--;	// VERY important !!!!!

        for(int i=0; i<n; i++){
        	int fac = factorial(n - i - 1);
        	// System.out.print("阶乘是: " + fac + " ");
        	// System.out.print("k is " + k + " ");
        	int index = k / fac;
        	// System.out.print("index: " + index + " ");
        	k = k % fac;
        	// System.out.print("k变为: " + k);
        	// System.out.println();
        	sb.append(list.get(index));
        	list.remove(index);
        }
        return sb.toString();
    }

    private int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }


    public static void main(String[] args) {
    	int n = 4;
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(n, 1));
    }
}
