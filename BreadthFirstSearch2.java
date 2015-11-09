import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class BreadthFirstSearch2{
	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> nodeValues = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		// A queue that tracks the current level
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();

		// A queue that tracks the next level
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();

		current.add(root);

		while(!current.isEmpty()){
			TreeNode node = current.remove();

			if (node.left!=null) {
				next.add(node.left);
			}
			if (node.right!=null) {
				next.add(node.right);
			}
			nodeValues.add(node.val);

			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(0, nodeValues); // add nodeValues to the beginning of the list.
				nodeValues = new ArrayList<Integer>();
			}
		}

		return result;
	}
}
