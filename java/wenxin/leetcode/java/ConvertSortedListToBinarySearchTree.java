/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	/*
	 * problem 109.
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(8);
		
		n1.next = n2;
		n2.next = n3;
		TreeNode root = sortedListToBST(n1);
		System.out.println(root.val);
		
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
    	
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return new TreeNode(head.val);
        
    	ListNode p1 = head;
    	ListNode p2 = head;
    	ListNode p3 = new ListNode(-1);
    	p3.next = head;
    	
    	while(p1.next!=null){
    		p1 = p1.next;
    		if(p1.next!=null)
    			p1 = p1.next;
    		p2 = p2.next;
    		p3 = p3.next;
    	}
    	
    	TreeNode root = new TreeNode(p2.val);
    	root.right = sortedListToBST(p2.next);
    	p3.next = null;
    	root.left = sortedListToBST(head);
    	
    	return root;
    }

}
