import java.util.*;

public class BST<Key extends Comparable> {
	private Node root;
	
	private class Node {
		Key key;
		Node left, right;
		
		public Node(Key key) {
			this(key, null, null);
		}
		
		public Node(Key key, Node left, Node right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
	
	public BST() { }
	
	public void add(Key key) {
		root = add(root, key);
	}
	
	private Node add(Node node, Key key) {
		if (node == null) {
			return new Node(key);
		}
		int cmp = key.compareTo(node.key);
		if (cmp <= 0) node.left = add(node.left, key);
		else		  node.right = add(node.right, key);
		return node;
	}
	
	public void inorderTraversal() {
		System.out.print("inorder: ");
		inorderHelper(root);
	}
	
	private void inorderHelper(Node node) {
		if (node == null) return;
		inorderHelper(node.left);
		System.out.printf("%s ", node.key);
		inorderHelper(node.right);
	}
	
	// 11.9 - preorderTraversal & postorderTraversal method
	public void preorderTraversal() {
		System.out.print("preorder: ");
		preorderHelper(root);
	}
	
	private void preorderHelper(Node node) {
		if (node == null) return;
		System.out.printf("%s ", node.key);
		inorderHelper(node.left);
		inorderHelper(node.right);
	}
	
	
	public void postorderTraversal() {
		System.out.print("postorder: ");
		postorderHelper(root);
	}
	
	private void postorderHelper(Node node) {
		if (node == null) return;
		postorderHelper(node.left);
		postorderHelper(node.right);
		System.out.printf("%s ", node.key);
	}
	
	// 11.12 - contains method - take an argument as a search key and return a reference to the node's data or null
	public Key contains(Key search) {
		return containsHelper(root, search);
	}
	
	private Key containsHelper(Node node, Key search) {
		if (node == null)							return null;
		else if (node.key.compareTo(search) == 0)	return node.key;
		else if (node.key.compareTo(search) > 0)	return containsHelper(node.left, search);
		else										return containsHelper(node.right, search);
	}
	
	public int compareTo(Key other) {
		return this.compareTo(other);
	}
	
	// 11.14 - level-order traversal
	public void levelOrder() {
		Queue<Node> levelOrder = new LinkedList<>();
		levelOrder.add(root);		// add root node
		
		while (!levelOrder.isEmpty()) {					// while there are nodes left
			Node nextNode = levelOrder.remove();		// get the next node in the queue
			System.out.print(nextNode.key + " ");		// print the node's value
			if (nextNode.left != null)		levelOrder.add(nextNode.left);
			if (nextNode.right != null)		levelOrder.add(nextNode.right);
		}
	}
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		Integer[] keys = {21, 68, 11, 13, 17, 97};
		for (Integer key : keys) {
			bst.add(key);
		}
		
		bst.inorderTraversal();
		System.out.println();
		
		bst.preorderTraversal();
		System.out.println();
		
		bst.postorderTraversal();
		System.out.println();
		
		bst.levelOrder();
		
		System.out.println("\n\n" + bst.contains(17));
	}
}
