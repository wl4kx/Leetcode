package wenxin.leetcode.java;

/*
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {

	public static void main(String[] args) {
		InsertionSortList instance = new InsertionSortList();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		
		
		
		ListNode root =instance.insertionSortList(n1);
		while(root!=null){
			System.out.print(root.val+" -> ");
			root = root.next;
		}

	}
	
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
        	return head;
        }
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = head.next;
        head.next = null;
		while (p != null) {
			ListNode temp = p.next;
			ListNode p2 = start;
			while (p2 != null) {
				if(p2.next==null){
					p2.next = p;
					p.next = null;
					break;
				}else if(p.val<p2.next.val){
					
					p.next = p2.next;
					p2.next = p;
					break;
				}else{
					p2 = p2.next;
				}
			}

			p=temp;

		}
		
		return start.next;
        
    }

}
