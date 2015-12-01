// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

import java.util.*;


public class PermutationsII{
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        res.add(arrayToList(nums));
        while(true){

        }
        return res;
    }

    private List<Integer> arrayToList(int[] nums){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        return list;
    }

    private int factorial(int n){
        if(n == 0 || n == 1){
             return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }

    private void nextPermutation(int[] nums){
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int j = nums.length-1;
                for(; j > i; j--){
                    if(nums[j] > nums[i]){
                        break;
                    }
                }
                swap(nums, i, j);
                reverse(nums, i+1);
                return;
            }
        }
        reverse(nums, 0);
        return;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,2};
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	PermutationsII p = new PermutationsII();
    	res = p.permuteUnique(nums);
    	for(List<Integer> list : res){
    		for(int i=0; i<list.size(); i++){
    			System.out.print(list.get(i) + " ");
    		}
    		System.out.println();
    	}
    }
}
