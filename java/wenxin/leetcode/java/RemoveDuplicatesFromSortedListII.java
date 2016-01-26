/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	/*
	 * problem 82.
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode result = deleteDuplicates(n1);
		
		while(result!=null){
			System.out.print(result.val+"-> ");
			result = result.next;
		}

	}
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	if(head==null)
    		return null;

    	ListNode start = new ListNode(1);
    	start.next = head;
    	
    	
    	ListNode pointer1 = head;
    	ListNode pointer2 = start;
    	
    	boolean foundDup = false;
    	while(pointer1!=null){
    		if(pointer1.next!=null && pointer1.val == pointer1.next.val){
    			foundDup = true;
    			pointer1 = pointer1.next;
    		}else{
    			if(foundDup){
    				pointer2.next = pointer1.next;
    				foundDup = false;
    				pointer1 = pointer1.next;
    			}else{
    				pointer1 = pointer1.next;
        			pointer2 = pointer2.next;	
    			}
    			
    		}
    		
    	}
    	
		return start.next;
        
    }
}
