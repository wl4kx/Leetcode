package wenxin.leetcode;

import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedLists {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }

    public ListNode mergeKLists(List<ListNode> lists) {
   /*     
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){  
            @Override  
            public int compare(ListNode n1, ListNode n2)  
            {  
                return n1.val-n2.val;  
            }  
        });  */
    	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>();
    for(int i=0;i<lists.size();i++)  
    {  
        ListNode node = lists.get(i);   
        if(node!=null)  
        {  
            heap.offer(node);  
        }  
    }  
    ListNode head = null;  
    ListNode pre = head;  
    while(heap.size()>0)  
    {  
        ListNode cur = heap.poll();  
        if(head == null)  
        {  
            head = cur;  
            pre = head;  
        }  
        else  
        {  
            pre.next = cur;  
        }  
        pre = cur;  
        if(cur.next!=null)  
            heap.offer(cur.next);  
    }  
    return head;  
    }

}
