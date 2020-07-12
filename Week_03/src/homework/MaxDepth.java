package homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-11
 */
public class MaxDepth {

	static int maxDepthRecursion(TreeNode root) {
		if (root == null) return 0;
		int maxLeft = maxDepthRecursion(root.left);
		int maxRight = maxDepthRecursion(root.right);
		return Math.max(maxLeft, maxRight) + 1;
	}

	static int maxDepthIterator(TreeNode root) {
		if (root == null) return 0;
		final Deque<TreeNode> stack = new LinkedList<>();
		int maxDepth = 0;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();

				root = root.right;
			}
		}
		return Math.max(0, 0);
	}


}
