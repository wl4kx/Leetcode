package wenxin.leetcode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * analysis: use merge sort. note here space is not strictly constant because used recursion.
	 * solution from http://rleetcode.blogspot.com/2014/01/sort-list-java.html
	 */
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        
        ListNode fast=head;
        ListNode slow=head;
       
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        ListNode left=head;
        
        left =sortList(left);
        right=sortList(right);
        
        return merge(left, right);
        
    }
    
    private ListNode merge(ListNode left, ListNode right){
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        
        ListNode preHead=new ListNode(-1);
        ListNode end=preHead;
        while (left!=null && right!=null){
            
            if (left.val<right.val){
                end.next=left;
                left=left.next;
            }
            else{
                end.next=right;
                right=right.next;
            }
             end=end.next;
        }
        
        if (left!=null){
            end.next=left;
        }
        
        if (right!=null){
            end.next=right;
        }
        
        return preHead.next;
        
    }
}
