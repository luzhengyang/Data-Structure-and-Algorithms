

import java.util.*;

public class ValidateBinarySearchTree{
	// inorder sequence should be sorted
	Stack<Integer> stack = new Stack<Integer>();
	public boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		inorder(root);
		int pre = stack.pop();
		while(!stack.isEmpty()){
			int cur = stack.pop();
			if(cur >= pre){
				return false;
			}
			pre = cur;
		}
		return true;
	}

	private void inorder(TreeNode node){
		inorder(node.left);
		stack.push(node.val);
		inorder(node.right);
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
