// Count the number of 1s in an integer

public class Count1s{
	public static int count1s(int num){
		int count = 0;
		while(num > 0){
			if((num & 1) == 1){
				count++;
			}
			num = num >> 1;
		}
		return count;
	}

	public static int count0s(int num){
		int count = 0;
		while(num > 0){
			if((num & 1) == 0){
				count++;
			}
			num = num >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count1s(11));
		System.out.println(count0s(11));
	}

}
