package wenxin.leetcode;

/*
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasCycle(ListNode head) {
    	ListNode start = new ListNode(0);
    	start.next = head;
        ListNode p1 = start;
        ListNode p2 = head;
        
        while(p1!=null && p2!=null){
        	if(p1==p2){
        		return true;
        	}
        	p1=p1.next;
        	p2=p2.next;
        	if(p2!=null){
        		p2 = p2.next;
        	}
        }
        
        return false;
        
    }
}
