class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class SumRootToLeafNumbers{
	public static void main(String[] args) {

	}

	int count = 0; // final result
	public int sumNumbers(TreeNode root){
		preOrder(root);
		return count;
	}

	public void preOrder(TreeNode node){
		// DFS PreOrder.
		if (node!=null) {
			if (node.left==null && node.right==null) {
				count += node.val;
			}
			if (node.left != null) {
				node.left.val = node.val*10 + node.left.val;
			}
			if (node.right != null) {
				node.right.val = node.val*10 + node.right.val;
			}
			preOrder(node.left);
			preOrder(node.right);
		}

	}
}
