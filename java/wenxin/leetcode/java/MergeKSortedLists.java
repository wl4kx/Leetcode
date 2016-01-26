package wenxin.leetcode.java;

import java.util.List;
import java.util.PriorityQueue;

/*
 * problem 23.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {

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
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				heap.offer(node);
			}
		}
		ListNode head = null;
		ListNode pre = head;
		while (heap.size() > 0) {
			ListNode cur = heap.poll();
			if (head == null) {
				head = cur;
				pre = head;
			} else {
				pre.next = cur;
			}
			pre = cur;
			if (cur.next != null)
				heap.offer(cur.next);
		}
		return head;
	}

	/*
	 * analysis, from http://www.cnblogs.com/TenosDoIt/p/3673188.html
	 * 
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

合并k个有序的链表，我们假设每个链表的平均长度是n。这�?题需要用到合并两个有序的链表子过�?

 

算法1�?

�?傻的做法就是�?1�?2合并�?12结果�?3合并�?123结果�?4合并，�??,123..k-1结果和k合并，我们计算一下复杂度�?

1�?2合并，遍�?2n个节�?

12结果�?3合并，遍�?3n个节�?

123结果�?4合并，遍�?4n个节�?

�?

123..k-1结果和k合并，遍历kn个节�?

总共遍历的节点数目为n(2+3+�?+k) = n*(k^2+k-2)/2, 因此时间复杂度是O(n*(k^2+k-2)/2) = O(nk^2)，代码如下：

class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if(lists.size() == 0)return NULL;
        ListNode*res = lists[0];
        for(int i = 1; i < lists.size(); i++)
            res = merge2list(res, lists[i]);
        return res;
    }
     
    ListNode *merge2list(ListNode *head1, ListNode*head2)
    {
        ListNode node(0), *res = &node;
        while(head1 && head2)
        {
            if(head1->val <= head2->val)
            {
                res->next = head1;
                head1 = head1->next;
            }
            else
            {
                res->next = head2;
                head2 = head2->next;
            }
            res = res->next;
        }
       if(head1)
            res->next = head1;
        else if(head2)
            res->next = head2;
        return node.next;
    }
};
算法2：利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表�?�可以很�?单的用�?�归来实现�?�因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk�?

递归的代码就不贴了�?�下面是非�?�归的代码非递归的�?�想是（以四个链表为例）�?                   本文地址

1�?3合并，合并结果放�?1的位�?

2�?4合并，合并结果放�?2的位�?

再把1�?2合并（相当于原来�?13 �? 24合并�?

 
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int n = lists.size();
        if(n == 0)return NULL;
        while(n >1)
        {
            int k = (n+1)/2;
            for(int i = 0; i < n/2; i++)
                lists[i] = merge2list(lists[i], lists[i + k]);
            n = k;
        }
        return lists[0];
    }
     
    ListNode *merge2list(ListNode *head1, ListNode*head2)
    {
        ListNode node(0), *res = &node;
        while(head1 && head2)
        {
            if(head1->val <= head2->val)
            {
                res->next = head1;
                head1 = head1->next;
            }
            else
            {
                res->next = head2;
                head2 = head2->next;
            }
            res = res->next;
        }
        if(head1)
            res->next = head1;
        else if(head2)
            res->next = head2;
        return node.next;
    }
};
 

算法3：维护一个k个大小的�?小堆，初始化堆中元素为每个链表的头结点，每次从堆中�?�择�?小的元素加入到结果链表，再�?�择该最小元素所在链表的下一个节点加入到堆中。这样当堆为空时，所有链表的节点都已经加入了结果链表。元素加入堆中的复杂度为O（longk），总共有kn个元素加入堆中，因此，复杂度也和算法2�?样是O（nklogk�?


class Solution {
private:
struct cmp
{
    bool operator ()(const ListNode *a, const ListNode *b)
    {
            return a->val > b->val;
    }
};
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int n = lists.size();
        if(n == 0)return NULL;
        ListNode node(0), *res = &node;
        priority_queue<ListNode*, vector<ListNode*>, cmp> que;
        for(int i = 0; i < n; i++)
            if(lists[i])
                que.push(lists[i]);
        while(!que.empty())
        {
            ListNode * p = que.top();
            que.pop();
            res->next = p;
            res = p;
             
            if(p->next)
                que.push(p->next);
        }
        return node.next;
    }
};
	 */
}
