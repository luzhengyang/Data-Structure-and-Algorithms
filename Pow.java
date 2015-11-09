public class Pow{
	public static void main(String[] args) {
		double x = 0;
		int n = 2;
		System.out.println(pow(x,n));
	}

	private static double power(double x, int n){
		// implement the relation:
		// x^n = x^(n/2) * x^(n/2) * x^(n%2)
		// using recursive method.

		if (n == 0) {
			return 1;
		}

		double var = power(x, n/2);
		// var * var * x, or var * var * 1

		if (n%2 == 0) {
			return var * var;
		}
		else {
			return var * var * x;
		}
	}

	public static double pow(double x, int n){
		double result;

		if (n < 0) {
			result = 1/power(x,-n);
		}
		else {
			result = power(x,n);
		}
		return result;
	}
}
