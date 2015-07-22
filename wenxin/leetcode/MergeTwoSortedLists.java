package wenxin.leetcode;

/*
 * problem 21.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode l3 = new ListNode(0);
    	ListNode pointer = l3;
    	while(true){
    		if(l1==null){
    			pointer.next = l2;
    			break;
    		}
    		if(l2==null){
    			pointer.next = l1;
    			break;
    		}
    		if(l1.val<l2.val){
    			pointer.next=new ListNode(l1.val);
    			l1 = l1.next;
    		}else{
    			pointer.next=new ListNode(l2.val);
    			l2 = l2.next;
    		}
			pointer = pointer.next;
    	}
    	l3 = l3.next;
    	return l3;
    }
    private class ListNode{
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	     }
	  }
}
