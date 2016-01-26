/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class PartitionList {

	/**
	 * @param args
	 */
	/*
	 * problem 86.
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static ListNode partition(ListNode head, int x) {
    	
    	if(head==null)
    		return null;
        
    	ListNode pointer = head;
    	ListNode smallerList = new ListNode(1);  
    	ListNode smallerListPoitner = smallerList;  
    	ListNode biggerList = new ListNode(1);  
    	ListNode biggerListPoitner = biggerList;
    	while(pointer!=null){
    		
    		if(pointer.val<x){
    			smallerListPoitner.next = pointer;
    			smallerListPoitner = smallerListPoitner.next;
    		}else{
    			biggerListPoitner.next = pointer;
    			biggerListPoitner = biggerListPoitner.next;
    		}
    		
    		pointer = pointer.next;
    		
    	}
    	biggerListPoitner.next = null;
    	smallerListPoitner.next = biggerList.next;
    	
    	return smallerList.next;
    	
    }
}
