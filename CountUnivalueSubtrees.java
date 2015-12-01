// Given a binary tree, count the number of uni-value subtrees.

// A Uni-value subtree means all nodes of the subtree have the same value.

// For example:
// Given binary tree,
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
// return 4.


public class CountUnivalueSubtrees{
	public static int countUnivalSubtrees(TreeNode root){
		if(root == null){
			return 0;
		}
		int[] count = new int[1];
		dfs(root, count);
		return count[0];
	}

	private static boolean dfs(TreeNode node, int[] count){
		if(node == null){
			return true;
		}

		boolean left = dfs(node.left, count);
		boolean right = dfs(node.right, count);
		if(!left || !right){
			return false;
		}
		if(node.left != null && node.left.val != node.val){
			return false;
		}
		if(node.right != null && node.right.val != node.val){
			return false;
		}
		count[0]++;
		return true;
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
