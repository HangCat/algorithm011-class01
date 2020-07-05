package linkedList;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-07-04
 */
public class ReverseList {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		System.out.println(node1);
		ListNode node = reverseList(node1);
		System.out.println(node);
	}

	static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode second = head.next;
		head.next = null;
		ListNode node = reverseList(second);
		second.next = head;
		return node;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
}
