// Divide two integers without using multiplication, division and mod operator.

// If it is overflow, return MAX_INT.

public class DivideTwoInteger{
	public int divide(int dividend, int divisor){
		if(dividend == Integer.MIN_VALUE && (divisor == 1 || divisor == -1)){
			return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return (int)divideLong(dividend, divisor);
	}

	public long divideLong(long dividend, long divisor){
		long res = 0;
		boolean positiveRes = (dividend > 0 && divisor > 0) ||(dividend < 0 && divisor < 0);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int power = 0;	// 获取最高位的指数
		while(dividend >= divisor){
			divisor <<= 1;
			power++;
		}
		divisor >>= power;
		power--;	// 得到最高位的指数

		while(power >=0){
			if(dividend >= divisor << power){
				res += 1 << power;
				dividend -= divisor << power;
			}
			power--;
		}

		return positiveRes ? res : -res;
	}

	public static void main(String[] args) {
		int dividend = 125;
		int divisor = 4;
		DivideTwoInteger dti = new DivideTwoInteger();
		System.out.println(dti.divide(dividend, divisor));
	}
}
