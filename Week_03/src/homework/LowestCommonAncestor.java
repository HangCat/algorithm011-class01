package homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-11
 */
public class LowestCommonAncestor {

	private static TreeNode ans = null;

	static TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p, q);
		return ans;
	}

	private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		boolean lson = dfs(root.left, p, q);
		boolean rson = dfs(root.right, p, q);
		if ((lson && rson) || (
				(root.val == p.val || root.val == q.val) && (lson || rson))) {
			ans = root;
		}
		return lson || rson || (root.val == p.val || root.val == q.val);
	}

	private final Map<Integer, TreeNode> parent = new HashMap<>();
	private final Set<Integer> visited = new HashSet<>();

	void dfsSet(TreeNode root) {
		if (root.left != null) {
			parent.put(root.left.val, root);
			dfsSet(root.left);
		}
		if (root.right != null) {
			parent.put(root.right.val, root);
			dfsSet(root.right);
		}
	}

	TreeNode ac(TreeNode root, TreeNode p, TreeNode q) {
		dfsSet(root);
		while (p != null) {
			visited.add(p.val);
			p = parent.get(p.val);
		}
		while (q != null) {
			if (visited.contains(q.val)) {
				return parent.get(q.val);
			}
			q = parent.get(q.val);
		}
		return null;
	}

	boolean dfsT(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		boolean lson = dfsT(root.left, p, q);
		boolean rson = dfsT(root.right, p, q);
		if ((lson && rson) || ((lson || rson) &&
				(root.val == q.val || root.val == p.val))) {
			ans = root;
		}
		return root.val == q.val || root.val == p.val;
	}




	/*private static final Map<Integer, TreeNode> parent = new HashMap<>();
	private static final Set<Integer> visited = new HashSet<>();

	static void dfsSetInMap(TreeNode root) {
		if (root.left != null) {
			parent.put(root.left.val, root);
			dfsSetInMap(root.left);
		}
		if (root.right != null) {
			parent.put(root.right.val, root);
			dfsSetInMap(root.right);
		}
	}

	static TreeNode lowestCommonAncestorIterator(TreeNode root, TreeNode p, TreeNode q) {
		dfsSetInMap(root);
		while (p != null) {
			visited.add(p.val);
			p = parent.get(p.val);
		}
		while (q != null) {
			if (visited.contains(q.val)) {
				return q;
			}
			q = parent.get(q.val);
		}
		return null;
	}*/

}
