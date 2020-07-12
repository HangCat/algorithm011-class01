package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-11
 */
public class BuildTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 中序遍历的节点元素与位置映射表
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < preorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildTree(preorder, inorderMap,
				0, preorder.length - 1, 0, inorder.length - 1);
	}

	// 基于模型： 前序遍历(preorder)root节点所在的位置是最前端
	//          中序遍历(inorder)  root节点左端就是左子树的所有集合，右子树也一样
	private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
	                           int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) return null;
		int rootVal = preorder[preLeft];
		final TreeNode root = new TreeNode(rootVal);

		int pivot = inorderMap.get(rootVal);
		int preLeftLength = pivot - inLeft;

		root.left = buildTree(preorder, inorderMap,
				preLeft + 1, preLeftLength + preLeft, inLeft, pivot - 1);

		root.right = buildTree(preorder, inorderMap,
				preLeft + preLeftLength + 1, preRight, pivot + 1, inRight);
		return root;
	}

	TreeNode bdt(int[] inorder, int[] preorder) {
		final Map<Integer, Integer> rootIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			rootIndexMap.put(inorder[i], i);
		}
		return bdt(preorder, rootIndexMap,
				0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode bdt(int[] preorder, Map<Integer, Integer> rootIndexMap,
	                     int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) return null;

		final int rootVal = preorder[preLeft];
		final TreeNode root = new TreeNode(rootVal);

		final int pivot = rootIndexMap.get(rootVal);
		final int leftSubTreeSize = pivot - inLeft;

		root.left = bdt(preorder, rootIndexMap,
				preLeft + 1, preLeft + leftSubTreeSize - 1, inLeft, pivot - 1);

		root.right = bdt(preorder, rootIndexMap,
				preLeft + leftSubTreeSize + 1, preRight, pivot + 1, inRight);

		return root;
	}


	public TreeNode buildTreeIterator(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int inorderIndex = 0;
		for (int i = 1; i < preorder.length; i++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if (node.val != inorder[inorderIndex]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.right);
			}
		}
		return root;
	}
}
