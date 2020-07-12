package homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 * @create 2020-07-08
 */
public class IsValidBST {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(20);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println(isValidBST(node1));
		System.out.println(Double.MAX_VALUE);
	}


	static boolean isValidBST(TreeNode root) {
		return validBSTRecursion(root, null, null);
	}

	static boolean validBSTRecursion(TreeNode node, Integer lower, Integer upper) {
		if (node == null) return true;
		int val = node.val;
		if (lower != null && val <= lower) return false;
		if (upper != null && val >= upper) return false;
		if (!validBSTRecursion(node.right, val, upper)) return false;
		if (!validBSTRecursion(node.left, lower, val)) return false;
		return true;
	}

	static boolean validBSTIterator(TreeNode root, Integer lower, Integer upper) {
		final Deque<TreeNode> stack = new LinkedList<>();
		double inorder = -Double.MAX_VALUE;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val <= inorder) return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}

	static boolean validBSTIterator2(TreeNode root) {
		final Deque<TreeNode> stack = new LinkedList<>();
		int minVal = -1;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				int val = root.val;
				if (minVal != -1 && minVal >= val) {
					return false;
				}
				minVal = val;
				root = root.right;
			}
		}
		return true;
	}

}
