/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	/*
	 * problem 83.
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		//n3.next = n4;
		
		ListNode result = deleteDuplicates(n1);
		
		while(result!=null){
			System.out.print(result.val+"-> ");
			result = result.next;
		}

	}
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	if(head==null)
    		return null;
    	
    	ListNode pointer = head;
    	
		while (pointer.next != null) {

			if (pointer.next.val == pointer.val) {
				pointer.next = pointer.next.next;
			} else {
				pointer = pointer.next;
			}

		}
    	
		return head;
        
    
    }
}
