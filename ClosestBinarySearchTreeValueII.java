// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

// Note:
// Given target value is a floating point.
// You may assume k is always valid, that is: k ≤ total nodes.
// You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


import java.util.*;

public class ClosestBinarySearchTreeValueII{
	public List<Integer> closestValue(TreeNode root, double target, int k){
		if(root == null){
			return new ArrayList<Integer>();
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<Integer> queue = new LinkedList<Integer>();

		while(root != null){
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(queue.size() < k){
				queue.offer(cur.val);
			}
			else{
				if(Math.abs(target - cur.val) < Math.abs(target - queue.peek())){
					queue.poll();
					queue.offer(cur.val);
				}
				else{
					break;
				}
			}
			if(cur.right != null){
				cur = cur.right;
				while(cur != null){
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
		return (List<Integer>)queue;
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
