package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description preorder N叉树
 * @create 2020-07-05
 */
public class PreorderNXTree {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		final ArrayList<Node> firstChild = new ArrayList<>();
		firstChild.add(node3);
		firstChild.add(node2);
		firstChild.add(node4);
		final ArrayList<Node> secondChild = new ArrayList<>();
		secondChild.add(node5);
		secondChild.add(node6);

		node3.children = secondChild;
		node1.children = firstChild;


		System.out.println("preorder = " + preorder(node1));
		System.out.println("preorder = " + preorderByIterator(node1));
	}

	// root -> left -> right
	// 递归
	static List<Integer> preorder(Node root) {
		if (root == null) return new ArrayList<>();
		final ArrayList<Integer> res = new ArrayList<>();
		res.add(root.val);
		List<Node> children = root.children;
		if (children != null) {
			for (Node child : children) {
				res.addAll(preorder(child));
			}
		}
		return res;
	}

	static List<Integer> preorderByIterator(Node root) {
		final LinkedList<Integer> res = new LinkedList<>();
		if (root == null) return res;

		final LinkedList<Node> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pollLast();
			res.add(node.val);
			if (node.children != null) {
				Collections.reverse(node.children);
				stack.addAll(node.children);
			}
		}
		return res;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}
