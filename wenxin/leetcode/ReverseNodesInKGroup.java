package wenxin.leetcode;

import java.util.ArrayList;

/*
 * problem 25.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		//l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode result = reverseKGroup(l1, 3);

		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}

		// ListNode[] results = reverseAll(l1);
		// System.out.println(results[0].val);
		// System.out.println(results[1].val);

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head==null){
			return null;
		}
		if(k==1){
			return head;
		}
		
		ArrayList<ListNode[]> list = new ArrayList<ListNode[]>();
		int count = 0;
		
		ListNode pointer = head;
		
		ArrayList<ListNode> rList = new ArrayList<ListNode>();
		ListNode temp = head;
		while(count<k && pointer!=null){
			pointer = pointer.next;
			if(count==0){
				rList.add(temp);
				pointer = temp;
			}
			if(pointer==null){
				break;
			}
			count++;
			if (count == k) {
				temp = pointer.next;
				pointer.next = null;
				count = 0;
				if (temp == null) {
					break;
				}
			}
		}
		
		if(count!=0){
			//has remaining nodes, remove last;
			rList.remove(rList.size()-1);
		}

		for(ListNode n : rList){
			ListNode[] results = new ListNode[2];
			results = reverseAll(n);
			list.add(results);
		}

		for (int i = 0; i < list.size()-1; i++) {
			ListNode[] results = list.get(i);
			ListNode[] results2 = list.get(i+1);
			results[1].next = results2[0];
			
		}
		 
		if(count!=0 && list.size()>0){
			list.get(list.size()-1)[1].next = temp;
		}
		if(list.size()>0)
		return list.get(0)[0];
		else
			return temp;
	}
	
	public static ListNode[] reverseAll(ListNode head){
		ListNode[] headAndTail = new ListNode[2];
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode front = new ListNode(-1);
		front.next = p1;
		
		while (p2 != null) {

			// ListNode temp = p2.next;
			p1.next = p2.next;
			p2.next = front.next;
			front.next = p2;

			p2 = p1.next;

		}

		headAndTail[0] = front.next;
		headAndTail[1] = head;
		return headAndTail;
	}

}
