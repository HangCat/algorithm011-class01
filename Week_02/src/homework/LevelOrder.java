package homework;

import java.util.*;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description LevelOrder 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @create 2020-07-05
 */
public class LevelOrder {

	public static void main(String[] args) {
		PreorderNXTree.Node node1 = new PreorderNXTree.Node(1);
		PreorderNXTree.Node node3 = new PreorderNXTree.Node(3);
		PreorderNXTree.Node node2 = new PreorderNXTree.Node(2);
		PreorderNXTree.Node node4 = new PreorderNXTree.Node(4);
		PreorderNXTree.Node node5 = new PreorderNXTree.Node(5);
		PreorderNXTree.Node node6 = new PreorderNXTree.Node(6);
		final ArrayList<PreorderNXTree.Node> firstChild = new ArrayList<>();
		firstChild.add(node3);
		firstChild.add(node2);
		firstChild.add(node4);
		final ArrayList<PreorderNXTree.Node> secondChild = new ArrayList<>();
		secondChild.add(node5);
		secondChild.add(node6);

		node3.children = secondChild;
		node1.children = firstChild;


	}

	static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				level.add(node.val);
				queue.addAll(node.children);
			}
			result.add(level);
		}
		return result;
	}

	static List<List<Integer>> levelOrderOpm(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		List<Node> previousLayer = Arrays.asList(root);

		while (!previousLayer.isEmpty()) {
			List<Node> currentLayer = new ArrayList<>();
			List<Integer> previousVals = new ArrayList<>();
			for (Node node : previousLayer) {
				previousVals.add(node.val);
				currentLayer.addAll(node.children);
			}
			result.add(previousVals);
			previousLayer = currentLayer;
		}

		return result;
	}

	private final List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> levelOrderByRecursion(Node root) {
		if (root != null) traverseNode(root, 0);
		return result;
	}
	private void traverseNode(Node node, int level) {
		if (result.size() <= level) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(node.val);
		for (Node child : node.children) {
			traverseNode(child, level + 1);
		}
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
