package wenxin.leetcode;
/*
 * problem 2.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

  	  ListNode newNode = new ListNode(0);
	  int carry = 0;
	  if(l1==null && l2==null)
		  return newNode;
	  
	  if(l1==null)
		  l1 = new ListNode(0);
	  
	  if(l2==null)
		  l2 = new ListNode(0);
	  int sum = l1.val+l2.val;
	  if(sum>=10){
		  newNode.val = sum - 10;
		  carry = 1;
	  }else{
		  newNode.val = sum;
	  }
	  
	  if(carry!=0){
		  if(l1.next!=null){
			  l1.next.val++;
		  }else{
			  l1.next = new ListNode(1);
		  }
	  }
	  ListNode next = addTwoNumbers(l1.next,l2.next);
	  if(next.next!=null || next.val!=0)
	    newNode.next = next;
	  return newNode;

        
    }
}
