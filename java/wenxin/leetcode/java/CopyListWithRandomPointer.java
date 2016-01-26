/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashMap;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 138.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * key: 1. first create a copy without random pointer.
	 * 2. use a hashmap to map from origin node to new node.
	 * 3. scan again for random pointer.
	 * code from Xiaopeng http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null)
    		return null;
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode newHead = new RandomListNode(head.label);
     
    	RandomListNode p = head;
    	RandomListNode q = newHead;
    	map.put(head, newHead);
     
    	p = p.next;
    	while (p != null) {
    		RandomListNode temp = new RandomListNode(p.label);
    		map.put(p, temp);
    		q.next = temp;
    		q = temp;
    		p = p.next;
    	}
     
    	p = head;
    	q = newHead;
    	while (p != null) {
    		if (p.random != null)
    			q.random = map.get(p.random);
    		else
    			q.random = null;
     
    		p = p.next;
    		q = q.next;
    	}
     
    	return newHead;
    }

}
