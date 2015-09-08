/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeInALinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void deleteNode(ListNode node) {
    	
    	ListNode pre = null;
    	while(true){
        	if(node.next!=null){
                node.val = node.next.val;
                pre = node;
                node = node.next;
        	}else{
        		pre.next =null;
        		break;
        	}
    	}
    }
    
}
