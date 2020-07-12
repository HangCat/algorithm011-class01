package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description 翻转一棵二叉树。
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * @create 2020-07-07
 */
public class InvertTree {
	public static void main(String[] args) {
		System.out.println("iterator = " + invertTreeIterator(buildNode()));
		System.out.println("recursion1 = " + invertTreeRecursion1(buildNode()));
		System.out.println("i1 = " + i1(buildNode()));
	}


	static TreeNode invertTreeIterator(TreeNode root) {
		if (root == null) return null;
		final Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);
		}
		return root;
	}

	static TreeNode invertTreeRecursion1(TreeNode root) {
		if (root == null) return null;
		TreeNode right = invertTreeRecursion1(root.right);
		TreeNode left = invertTreeRecursion1(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	static TreeNode invertTreeRecursion2(TreeNode root) {
		if (root == null) return null;
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		invertTreeRecursion2(root.left);
		invertTreeRecursion2(root.right);
		return root;
	}

	static TreeNode i1(TreeNode root) {
		if (root == null) return null;
		TreeNode left = i1(root.left);
		TreeNode right = i1(root.right);
		root.left = right;
		root.right = left;
		return root;
	}


	private static TreeNode buildNode() {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);

		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;

		return node4;
	}
}
