import java.util.HashMap;

public class TwoSum{
	public int[] twoSum(int[] nums, int target){
		int[] result = new int[2];

		if (nums == null || nums.length < 2) {
			return result;
		}

		HashMap <Integer,Integer> map = new HashMap<Integer,Integer> ();

		for (int i=0; i<nums.length; i++) {
			if (!map.containsKey(target - nums[i])) {
				map.put(nums[i], i);
			}
			else{
				result[0] = map.get(target - nums[i]) + 1;
				result[1] = i + 1;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		TwoSum tow_sum = new TwoSum();
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] result = tow_sum.twoSum(numbers,target);
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}