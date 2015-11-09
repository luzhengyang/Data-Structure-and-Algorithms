public class QuickSort{
	public static int partition(int arr[], int left, int right){
	     int i = left, j = right;
	     int tmp;
	     int pivot = arr[(left + right) / 2];

	     while (i <= j) {
	           while (arr[i] < pivot)
	                 i++;
	           while (arr[j] > pivot)
	                 j--;
	           if (i <= j) {
	                 tmp = arr[i];
	                 arr[i] = arr[j];
	                 arr[j] = tmp;
	                 i++;
	                 j--;
	           }
	     };

	     return i;
	}

	public static void quickSort(int arr[], int left, int right){
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}


	public static void main(String[] args) {
		int[] nums = {10,5,39,23,8,45,23,41,18};
		quickSort(nums, 0, nums.length-1);
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
