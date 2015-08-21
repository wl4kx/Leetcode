package wenxin.leetcode;

import java.util.HashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode_ head;
	public ListNode_ tail;
	public HashMap<Integer, ListNode_> map;
	public int capacity;
	public int count;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		count = 0;
		head = new ListNode_(0, 0);
		tail = new ListNode_(0, 0);
		head.next = tail;
		tail.pre = head;
		map = new HashMap<Integer, ListNode_>();
	}

	public int get(int key) {

		ListNode_ node = map.get(key);
		if (node == null) {
			return -1;
		}
		node.pre.next = node.next;
		node.next.pre = node.pre;

		node.pre = head;
		node.next = head.next;
		head.next = node;
		node.next.pre = node;

		return node.val;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			ListNode_ node = map.get(key);
			node.val = value;

			node.pre.next = node.next;
			node.next.pre = node.pre;

			node.pre = head;
			node.next = head.next;
			head.next = node;
			node.next.pre = node;
		} else {
			if (count == capacity) {
				ListNode_ lastNode = tail.pre;
				map.remove(lastNode.key);
				tail.pre = lastNode.pre;
				tail.pre.next = tail;
			} else {
				count++;
			}
			ListNode_ node = new ListNode_(key, value);
			map.put(key, node);
			node.pre = head;
			node.next = head.next;
			head.next = node;
			node.next.pre = node;
		}

	}

}

class ListNode_ {
	int key;
	int val;
	ListNode_ pre = null;
	ListNode_ next = null;

	ListNode_(int key, int val) {
		this.val = val;
		this.key = key;
	}
}
