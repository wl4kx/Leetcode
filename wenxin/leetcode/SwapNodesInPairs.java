package wenxin.leetcode;


/*
 * problem 24.
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
	
	public static void main(String[] args){
		SwapNodesInPairs instance = new SwapNodesInPairs();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode result  = instance.swapPairs(l1);
		while(result!=null){
			System.out.print(result.val+" -> ");
			result = result.next;
		}
	}
	
    public ListNode swapPairs(ListNode head) {

//    	ListNode n=head;    		
//    	int temp =0;
//
//    	while(head!=null && head.next!=null){
//    		
//    		temp = head.val;
//    		head.val = head.next.val;
//    		head.next.val= temp;
//    		head = head.next.next;
//    		
//    	}
//		return n;
        if(head==null){
        	return null;
        }
        if(head.next==null){
        	return head;
        }
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	ListNode front = head.next;
    	while(p2!=null && p2.next!=null){
    		ListNode temp= p2.next;
    		if(p2.next.next==null){
    			p1.next = temp;
    			p2.next = p1;
    			p2=null;
    			break;
    		}else{
    			p1.next = p2.next.next;
        		p2.next = p1;
        		p1 = temp;
        		p2 = p1.next;
 			
    		}
       	}
    	if(p2!=null){
    		p2.next = p1;
    		p1.next = null;
    	}
    	return front;
        /*
         *         // Start typing your Java solution below
        // DO NOT write main() function
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode n1 = helper, n2=head;
        
        while(n2!=null && n2.next!=null){
            ListNode temp = n2.next.next;
            n2.next.next=n1.next;
            n1.next=n2.next;
            n2.next=temp;
            n1=n2;
            n2=n1.next;
        }
        
        return helper.next;
         */
    	
    }
}
