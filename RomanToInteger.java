public class RomanToInteger{
	public static void main(String[] args) {

	}

	public int romanToInt(String s){
		int result = 0;

		// traverse s from the end
		for (int i=s.length()-1; i>=0; i--) {
			char c = s.charAt(i);

			if (c=='I') {
				if (result >= 5) {
					// it means we have traversed 'V'
					// 'I' must be on the left of 'V'
					result = result-1;
				}
				else {
					result = result+1;
				}
			}
			// when it matches 'V','L','D','M'
			// add 5, 50, 500, 1000
			else if (c=='V') {
				result = result+5;
			}

			else if (c=='X') {
				if (result >= 40) {
					// it means we have traversed 'L'
					// 'X' must be on the left of 'L'
					result = result-10;
				}
				else {
					result = result+10;
				}
			}

			else if (c=='L') {
				result = result+50;
			}

			else if (c=='C') {
				if (result >= 400) {
					// it means we have traversed 'D'
					// 'C' must be on the left of 'D'
					result = result-100;
				}
				else {
					result = result+100;
				}
			}

			else if (c=='D') {
				result = result+500;
			}

			if (c=='M') {
				result = result+1000;
			}
		}

		return result;
	}
}
