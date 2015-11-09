/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Tags: Tree, BFS, Stack
 */

import java.util.*;

public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
        	return res;
        }


        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean direction = true;	//控制方向，向左为true，向右为false

        while(!queue.isEmpty()){
        	List<Integer> li = new ArrayList<Integer>();
        	int size = queue.size();
        	for(int i=0; i<size; i++)
        	{
        		TreeNode node = queue.poll();
	        	if(direction){
	        		li.add(node.val);
	        	}
	        	else{
	        		li.add(0,node.val);
	        	}
	        	if(node.left != null){
	        		queue.add(node.left);
	        	}
	        	if(node.right != null){
	        		queue.add(node.right);
	        	}
        	}
        	res.add(li);
        	direction = !direction;	// 遍历完一层后改变方向

        }
        return res;
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
