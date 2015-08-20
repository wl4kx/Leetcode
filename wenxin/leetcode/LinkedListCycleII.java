package wenxin.leetcode;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * analysis: http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
	 */
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p1!=null && p2!=null){

        	p1=p1.next;
        	p2=p2.next;
        	if(p2!=null){
        		p2 = p2.next;
        	}
        	if(p1==p2){
        		break;
        	}
        }
        if(p1==null || p2==null){
        	return null;
        }
        
        p2 = head;
        
        while(p1!=p2){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        
        return p1;
        
    }

}
