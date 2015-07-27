package wenxin.leetcode;

/*
 * problem 19.
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		if(head.next == null && n == 1)
			return null;

		int count = 0;
		ListNode aPointer = head;
		ListNode bPointer = head;
		int length = 1;
		while (aPointer.next != null) {

			if (count == n) {
				aPointer = aPointer.next;
				bPointer = bPointer.next;
			} else {
				aPointer = aPointer.next;
				count++;
			}
			length++;
		}
		
		if(length == n){
			return aPointer.next;
		}else{
			bPointer.next = bPointer.next.next;
			return head;
		}
	}
}