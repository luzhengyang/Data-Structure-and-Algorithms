// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

// Note: If the given node has no in-order successor in the tree, return null.


import java.util.*;

public class InorderSuccessor{
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		if(root == null || p == null){
			return null;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != p){
			stack.push(cur);
			if(cur.val > p.val){
				cur = cur.left;
			}
			else{
				cur = cur.right;
			}
		}

		if(cur.right != null){
			cur = cur.right;
			while(cur.left != null){
				cur = cur.left;
			}
			return cur;
		}
		else{
			while(!stack.isEmpty() && stack.peek().val < p.val){
				stack.pop();
			}
			return stack.isEmpty() ? null : stack.pop();
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(10);
		TreeNode t8 = new TreeNode(14);
		TreeNode t9 = new TreeNode(13);
		t1.left = t2;
		t1.right = t7;
		t3.left = t3;
		t2.right = t4;
		t4.left = t5;
		t4.right = t6;
		t7.right = t8;
		t8.left = t9;

		TreeNode successor = inorderSuccessor(t1, t4);
		System.out.println(successor.val);
	}
}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
