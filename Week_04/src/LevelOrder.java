import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhouyp
 * @program Week_04
 * @description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @create 2020-07-18
 */
public class LevelOrder {

	public static void main(String[] args) {
		final TreeNode node = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
		TreeNode.prettyPrintTree(node,"node",true);
		TreeNode.prettyPrintTree(node,"node",false);
		System.out.println(levelOrder(node));
	}

	static List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> res = new ArrayList<>();
		final Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) queue.add(root);
		while (!queue.isEmpty()) {
			final List<Integer> list = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				final TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			res.add(list);
		}
		return res;
	}

}
