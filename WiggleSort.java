// Given an unsorted array nums,
// reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// For example, given nums = [3, 5, 2, 1, 6, 4],
// one possible answer is [1, 6, 2, 5, 3, 4].

// 偶数位的数比前一个数要小
// 奇数位的数比前一个数要大

public class WiggleSort{
	public static void wiggleSort(int[] nums){
		if(nums==null || nums.length<=0){
			return;
		}
		for(int i=1; i<nums.length; i++){
			if((i%2==0 && nums[i]>nums[i-1]) || (i%2==1 && nums[i]<nums[i-1])){
				int temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;
				System.out.println("done");
			}
		}
	}


	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4};
		wiggleSort(nums);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}
}
