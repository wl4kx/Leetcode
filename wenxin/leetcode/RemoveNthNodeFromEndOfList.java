package wenxin.leetcode;

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