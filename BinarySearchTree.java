class BinaryTreeNode{
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode(int x){
		val = x;
		left = null;
		right = null;
	}
}

public class BinarySearchTree{
	public BinaryTreeNode search(BinaryTreeNode root, int key){
		// search a key in binary search tree, O(log n)
		if(root == null || root.val == key){
			return root;
		}
		if(key < root.val){
			return search(root.left, key);
		}
		return search(root.right, key);
	}

	public BinaryTreeNode insert(BinaryTreeNode root, int key){
		// insert a key into binary search tree, O(log n)
		if(root == null){
			root = new BinaryTreeNode(key);
			return root;
		}
		if(key < root.val){
			insert(root.left, key);
		}
		else if (root.val > key) {
			insert(root.right, key);
		}
		return root;
	}

	public BinaryTreeNode maxValueNode(BinaryTreeNode root){
		BinaryTreeNode cur = root;
		if(root != null){
			while(cur.right != null){
				cur = cur.right;
			}
		}
		return cur;
	}

	public BinaryTreeNode minValueNode(BinaryTreeNode root){
		// find the node with minimum value(most left)
		BinaryTreeNode cur = root;
		if(root != null){
			while(cur.left != null){
				cur = cur.left;
			}
		}
		return cur;
	}

	public BinaryTreeNode remove(BinaryTreeNode root, int key){
		// remove a node from the tree
		if(root == null){
			return root;
		}
		if(key < root.val){
			remove(root.left, key);
		}
		else if(root.val < key){
			remove(root.right, key);
		}
		else if(root.left != null && root.right != null){
			root.val = minValueNode(root.right).val;
			root.right = remove(root.right, root.val);
		}
		else{
			root = root.left!=null?root.left:root.right;
		}
		return root;
	}

}
