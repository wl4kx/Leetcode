package wenxin.leetcode.java;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode evenHead = head.next;
		ListNode oddTail = head.next.next;
		ListNode evenTail = head.next;
		ListNode oddPointer = head;
		ListNode evenPointer = head.next;
		ListNode pointer = evenPointer.next;

		boolean odd = true;
		while (pointer != null) {
			if (odd) {
				oddPointer.next = pointer;
				oddPointer = oddPointer.next;
				oddTail = pointer;
			} else {
				evenPointer.next = pointer;
				evenPointer = evenPointer.next;
				evenTail = pointer;
			}
			pointer = pointer.next;
			odd = !odd;
		}
		evenTail.next = null;
		oddTail.next = evenHead;
		return head;
	}

}
