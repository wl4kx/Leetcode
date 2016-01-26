/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 61.
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
	//	n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RotateList instance = new RotateList();
		ListNode head = instance.rotateRight(n1, 2);
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		
	}
	
	/*
	 * Key: link tail to head. http://rleetcode.blogspot.com/2014/01/rotate-list-java.html
	 */
	public ListNode rotateRight(ListNode head, int n) {
        if (head==null|| n==0){
            return head;
        }
        
        int len=1;
        ListNode last=head;
        
        // calculate the lenght of given list
        while(last.next!=null){
            last=last.next;
            len++;
        }
        
        last.next=head;
        
        // Should considered the situtation that n larger than given list's length
        int k=len-n%len;
        ListNode preHead=last;
        
        // find the point which are previuse for our target head
        while(k>0){
            preHead=preHead.next;
            k--;
        }
        
        head=preHead.next;
        preHead.next=null;
        
        return head;
        
    }

}
