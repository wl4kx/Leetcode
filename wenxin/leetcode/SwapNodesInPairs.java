package wenxin.leetcode;


/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

    	ListNode n=head;    		
    	int temp =0;

    	while(head!=null && head.next!=null){
    		
    		temp = head.val;
    		head.val = head.next.val;
    		head.next.val= temp;
    		head = head.next.next;
    		
    	}
		return n;
        
    
        
    }
}
