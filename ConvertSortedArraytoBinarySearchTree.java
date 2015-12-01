// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


public class ConvertSortedArraytoBinarySearchTree{
	public TreeNode convertArrayToBST(int[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}

		TreeNode root = arrayToBST(nums, 0, nums.length-1);
		return root;
	}

	private TreeNode arrayToBST(int[] nums, int start, int end){
		if(start > end){		// DON'T forget this step
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = arrayToBST(nums, start, mid-1);
		root.right = arrayToBST(nums, mid+1, end);
		return root;
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}
