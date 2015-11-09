public class MaxHeap{
	public static void makeMaxHeap(int[] a, int size){
		for(int i=size/2; i>0; i--){
			int m = a[i-1];
			int c = 2*i;
			while(c <= size){
				if(c < size && a[c-1] < a[c]){
					c++;
				}
				if(m > a[c-1]){
					break;
				}
				a[c/2 - 1] = a[c-1];
				c = c*2;
			}
			a[c/2 - 1] = m;
		}
	}

	public static void main(String[] args) {
		int m = 4;
		int[] a = {4,4,5,3,1};
		int profit = 0;
		for(int i=0; i<m; i++){
			makeMaxHeap(a,5);
			profit = profit + a[0];
			a[0] = a[0] - 1;
		}


		System.out.println(profit);
	}
}
