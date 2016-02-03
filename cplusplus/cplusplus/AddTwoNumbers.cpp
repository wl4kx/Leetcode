#include <vector>
#include <unordered_map>
#include <iostream>
#include <string>
#include "ListNode.h"
using namespace std;
class AddTwoNumbers {

public:

	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode *head = new ListNode(0);
		if (l1 == NULL && l2 == NULL) {
			return head;
		}
		int carry = 0;
		ListNode *pointer = head;
		while (l1 != NULL || l2 != NULL) {
			int sum = 0;
			if (l1 != NULL) {
				sum += l1->val;
				l1 = l1->next;
			}
			if (l2 != NULL) {
				sum += l2->val;
				l2 = l2->next;
			}
			sum += carry;
			if (sum > 9) {
				carry = 1;
				sum -= 10;
			}
			else {
				carry = 0;
			}
			ListNode *aNode = new ListNode(sum);
			pointer->next = aNode;
			pointer = pointer->next;
		}
		if (carry != 0) {
			pointer->next = new ListNode(1);
		}
		return head->next;
	}
};

int main() {

	AddTwoNumbers s;
	ListNode *n1 = new ListNode(5);
	ListNode *n2 = new ListNode(5);
	ListNode *ret = s.addTwoNumbers(n1, n2);
	while (ret != NULL) {
		cout << ret->val << " ";
		ret = ret->next;
	}
	system("pause");
}