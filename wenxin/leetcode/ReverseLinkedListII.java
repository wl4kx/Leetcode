/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 92.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	  1->3->2->4->5->NULL
return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		
		
		int count = n-m;
		int k = m;
		ListNode p1 = new ListNode(0);
		p1.next = head;
		//travel to the node before m;
		while(k>1){
			p1=p1.next;
			k--;
		}
		
		ListNode p2 = p1.next;
		while(count>0){

			ListNode temp = p2.next;
			p2.next = temp.next;
			temp.next=p1.next;
			p1.next = temp;
			
			count--;
		}
		
		if(m>1){
			return head;
		}
		
		return p1.next;
		
	}
}
