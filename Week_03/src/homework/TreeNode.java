package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-11
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static void main(String[] args) {
		TreeNode treeNode = stringToTreeNode("[1,2,3,null,null,4,5]");
		System.out.println(treeNode);
	}

	public static String treeNodeToString(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		StringBuilder output = new StringBuilder();
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (node == null) {
				output.append("null, ");
				continue;
			}

			output.append(node.val).append(", ");
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
		if (node == null) {
			System.out.println("Empty tree");
			return;
		}

		if (node.right != null) {
			prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}

		System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

		if (node.left != null) {
			prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
		}
	}

	public static void prettyPrintTree(TreeNode node) {
		prettyPrintTree(node, "", true);
	}


	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
