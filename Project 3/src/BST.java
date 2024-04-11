import java.util.ArrayList;

//Zhenyu Wu, CSE 017
public class BST<E extends Comparable<E>> {
	private TreeNode root;
	private int size;
	
	private class TreeNode{
		E value;
		TreeNode left;
		TreeNode right;
		TreeNode(E val){
			value = val;
			left = right = null;
		}
	}
	//O(1)
	public BST(){
		size = 0;
		root = null;
	}
	//O(n)
	public BST(ArrayList<E>list) {
		for(int i = 0; i < list.size(); i++) {
			insert(list.get(i));
		}
	}
	//O(1)
	public int size() {
		return size;
	}
	///O(1)
	public boolean isEmpty() {
		return(size == 0);
	}
	//O(1)
	public void clear() {
		root = null;
	}
	//O(logn)
	public int search(E item) {
		TreeNode current = root;
		int count = 0;
		while(current != null) {
			if(item.compareTo(current.value) < 0) {
				current = current.left;
				count++;
			}
			else if(item.compareTo(current.value) > 0) {
				current = current.right;
				count++;
			}
			else {
				return count;
			}
		}
		return count;
	}
	//O(logn)
	public int insert(E item) {
		int count = 0;
		if(root == null) {
			root = new TreeNode(item);
			return 0;
		}
		else {
			TreeNode current = root;
			TreeNode parent = null;
			while(current != null) {
				parent = current;
				if(item.compareTo(current.value) < 0) {
					current = current.left;
					count ++;
				}
				else if(item.compareTo(current.value) > 0) {
					current = current.right;
					count ++;
				}
				else {
					return -1;
				}
			}
			if(item.compareTo(parent.value) < 0) {
				parent.left = new TreeNode(item);
				count ++;
			}
			else {
				parent.right = new TreeNode(item);
				count ++;
			}
		}
		size ++;
		return count;
	}
	//O(logn)
	public int delete(E item) {
		TreeNode current = root;
		TreeNode parent = null;
		int count = 0;
		while(current != null) {
			parent = current;
			if(item.compareTo(current.value) < 0) {
				current = current.left;
				count ++;
			}
			else if(item.compareTo(current.value) > 0) {
				current = current.right;
				count ++;
			}
			else {
				break;
			}
		}
		if(current == null) {
			return count;
		}
		else if(current.left == null) {
			if(parent == null) {
				root = current.right;
				count ++;
			}
			else {
				if(item.compareTo(parent.value)<0) {
					parent.left = current.right;
					count ++;
				}
				else {
					parent.right = current.right;
					count++;
				}
			}
		}
		else {
			TreeNode rightMostParent = current;
			TreeNode rightMost = current.left;
			while(rightMost.right != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.right;
				count++;
			}
			current.value = rightMost.value;
			count++;
			if(rightMostParent.right == rightMost) {
				rightMostParent.right = rightMost.left;
				count++;
			}
			else {
				rightMostParent.left = rightMost.left; 
				count++;
			}
		}
		size--;
		return count;
	}
	//O(n)
	public void inorder() {
		inorder(root);
	}
	private void inorder(TreeNode node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.value.toString()+ " ");
			inorder(node.right);
		}
	}
	//O(n)
	public void preorder() {
		preorder(root);
	}
	private void preorder(TreeNode node) {
		if(node != null) {
			System.out.print(node.value.toString());
			preorder(node.left);
			preorder(node.right);
		}
	}
	//O(n)
	public void postorder() {
		postorder(root);
	}
	private void postorder(TreeNode node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");
		}
	}
	//O(n)
	public int leafNode() {
		return leafNode(root);
	}
	private int leafNode(TreeNode node) {
		if(node == null) {
			return 0;
		}
		else if(node.left == null && node.right == null) {
			return 1;
		}
		else {
			return leafNode(node.left) + leafNode(node.right);
		}
	}
	//O(n)
	public int height() {
		return height(root);
	}
	private int height(TreeNode node) {
		if(node == null) {
			return 0;
		}
		else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}
	//O(n)
	public boolean isBalanced() {
		return isBalanced(root);
	}
	private boolean isBalanced(TreeNode node) {
		if(node.left == null && node.right == null) {
			return true;
		}
		else {
			return (Math.abs(height(node.left)- height(node.right)) <= 1) && isBalanced(node.left) && isBalanced(node.right);
		}
	}
	
}
