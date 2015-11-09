/* This is a java implementation of the KMP algorithm.

There is a good explanation on the following web page:
http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html

The implementation is based on the pseudo code on the following web page:
https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-string-searching-algorithms/
*/

public class KMP{
	public static void main(String[] args) {
		char[] text = {'A','B','A','B','A','C'};
		char[] pattern = {'B','A','A'};
		System.out.println(KMP.KnuthMorrisPratt(text,pattern));
		// int[] F = KMP.failureFunction(pattern);
		// for (int i = 0; i<F.length; i++) {
		// 	System.out.println(F[i]);
		// }
	}
	public static int[] failureFunction(char[] pattern){
		int m = pattern.length;
		int[] F = new int[pattern.length+1];	// F[0] is the empty string
		F[0] = 0;	// always true
		F[1] = 0;	// always true
		for (int i=2; i<=m; i++) {
			// j is the index of the next partial match of the string
			// under indexi-1.
			// This can also be considered as the length of the next
			int j = F[i-1];
			for (; ; ) {
				if (pattern[j] == pattern[i-1]) {
					F[i] = j+1;
					break;
				}
				if (j==0) {
					F[i] = 0;
					break;
				}
				j = F[i];
			}
		}
		return F;
	}
	public static boolean KnuthMorrisPratt(char[] text, char[] pattern){
		int[] F = KMP.failureFunction(pattern);
		int i = 0;
		int j = 0;
		for (; ; ) {
			if (j == text.length) {
				// reach the end of text
				break;
			}
			if (text[j] == pattern[i]) {
				i++;
				j++;
				if (i == pattern.length) {
					// match found
					return true;
				}
			}
			else if (i>0) {
				i = F[i];
			}
			else {
				j++;
			}
		}
		return false;
	}
}
