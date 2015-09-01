/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//iter
    public ListNode reverseList(ListNode head) {
    	
    	ListNode before = null;
    	ListNode tmp = head;
    	while (tmp != null) {
    		ListNode next = tmp.next;
    	    tmp.next = before;
    	    before = tmp;
    	    tmp = next;
    	}
    	return before;
    	
    }

    //recur
    public ListNode reverseList2(ListNode head) {
    	
    	if(head==null || head.next == null){
    		return head;
    	}
    	
    	ListNode temp = head.next;
    	head.next = null;
    	ListNode newHead = reverseList2(temp);
    	temp.next = head;
    	
    	return newHead;
    	
    	
    }
}
