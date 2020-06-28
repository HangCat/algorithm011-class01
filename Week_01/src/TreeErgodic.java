import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhouyp
 * @program Week_01
 * @description 树遍历
 * @create 2020-06-28
 */
public class TreeErgodic {

	static class TreeNode<T> {

		public TreeNode(T t, boolean isTop) {
			this.data = t;
			this.isTop = isTop;
		}

		public TreeNode(T t) {
			this(t, false);
		}

		public TreeNode() {
		}

		T data;
		boolean isTop;
		TreeNode<T> left;
		TreeNode<T> right;
	}

	//         A
	//       /   \
	//      B     C
	//     / \   / \
	//    D   E F   G
	public static void main(String[] args) {
		System.out.print("preOrder=");
		preOder(buildTreeNode());
		System.out.println();

		System.out.print("nonRecursivePreOrder=");
		nonRecursivePreOrder(buildTreeNode());
		System.out.println();

		System.out.print("pre=");
		pre(buildTreeNode());
		System.out.println();

		System.out.print("inOrder=");
		inOrder(buildTreeNode());
		System.out.println();

		System.out.print("nonRecursiveInOrder=");
		nonRecursiveInOrder(buildTreeNode());
		System.out.println();

		System.out.print("postOrder=");
		postOrder(buildTreeNode());
		System.out.println();

		System.out.print("nonRecursivePostOrder=");
		nonRecursivePostOrder(buildTreeNode());
		System.out.println();
	}

	// 前序 root -> left -> right
	static void preOder(TreeNode<String> treeNode) {
		if (treeNode == null) return;
		System.out.print(treeNode.data);
		preOder(treeNode.left);
		preOder(treeNode.right);
	}

	static void nonRecursivePreOrder(TreeNode<String> root) {
		final Stack<TreeNode<String>> stack = new Stack<>();
		TreeNode<String> current = root;
		while ((current != null) || (!stack.isEmpty())) {
			if (current != null) {
				System.out.print(current.data);
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				current = current.right;
			}
		}
	}

	// left -> root ->right
	static void inOrder(TreeNode<String> root) {
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}

	// 取的时候，顺序是 left -> root -> right
	// 栈放数据的时候，就是顺着左节点push的
	// 所以取的时候，只需要在栈满之后 pop 数据就可以满足中序
	static void nonRecursiveInOrder(TreeNode<String> root) {
		Stack<TreeNode<String>> stack = new Stack<>();
		TreeNode<String> current = root;
		while ((current != null) || (!stack.empty())) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.print(current.data);
				current = current.right;
			}
		}
	}

	// left -> right -> root
	static void postOrder(TreeNode<String> root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);
	}

	static void nonRecursivePostOrder(TreeNode<String> root) {
		Stack<TreeNode<String>> stack = new Stack<>();
		TreeNode<String> curr = root;
		while ((curr != null) || (!stack.empty())) {
			if (curr != null) {
				curr.isTop = true;
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.peek();
				stack.pop();
				if (curr.isTop) {
					curr.isTop = false;
					stack.push(curr);
					curr = curr.right;
				} else {
					System.out.print(curr.data);
					curr = null;
				}
			}
		}
	}

	// 广度优先
	static void bfs(TreeNode<String> root) {
		Queue<TreeNode<String>> queue = new LinkedList<>();
		TreeNode<String> curr = root;
		while ((curr != null) || (!queue.isEmpty())) {
			if (curr != null) {
				System.out.print(curr.data);
				queue.add(curr.left);
				queue.add(curr.right);
				curr = queue.poll();
			} else {
				curr = queue.poll();
			}
		}
	}

	static TreeNode<String> buildTreeNode() {
		final TreeNode<String> nodeA = new TreeNode<>("A", true);
		final TreeNode<String> nodeB = new TreeNode<>("B");
		final TreeNode<String> nodeC = new TreeNode<>("C");
		final TreeNode<String> nodeD = new TreeNode<>("D");
		final TreeNode<String> nodeE = new TreeNode<>("E");
		final TreeNode<String> nodeF = new TreeNode<>("F");
		final TreeNode<String> nodeG = new TreeNode<>("G");
		nodeA.left = nodeB;
		nodeB.left = nodeD;
		nodeB.right = nodeE;

		nodeA.right = nodeC;
		nodeC.left = nodeF;
		nodeC.right = nodeG;
		return nodeA;
	}


	// root -> left -> right
	static void pre(TreeNode<String> root) {
		final Stack<TreeNode<String>> stack = new Stack<>();
		TreeNode<String> curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				System.out.print(curr.data);
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				curr = curr.right;
			}
		}
	}

	static void in(TreeNode<String> root) {
		final Stack<TreeNode<String>> stack = new Stack<>();
		TreeNode<String> curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.print(curr.data);
				curr = curr.right;
			}
		}
	}
}
