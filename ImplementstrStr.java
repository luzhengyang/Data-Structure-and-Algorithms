public class ImplementstrStr{
	public static void main(String[] args) {

	}

	private static int[] failureFunction(char[] pattern){
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

	public static int strStr(String haystack, String needle){
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() <= haystack.length()) {
			int[] F = failureFunction(needle.toCharArray());
			int i = 0; // cursor on haystack
			int j = 0; // cursor on needle
			while (i < haystack.length()) {
				if (haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
					if (j == needle.length()) {
						// j is at the end of needle
						return i-j;
					}
				}

				else if (j > 0) {
					j = F[j];
				}

				else {
					i++;
				}
			}
		}
		return -1;
	}
}
