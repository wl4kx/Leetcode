#include <vector>
#include <unordered_map>
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> ret(2, 0);

		unordered_map<int, int> map;
		int size = nums.size();
		for (int i = 0; i < size; i++)
		{
			int n1 = nums[i];
			unordered_map<int, int>::const_iterator got = map.find(target - n1);
			if (got != map.end()) {
				ret[0] = got->second + 1;
				ret[1] = i + 1;
				break;
			}
			else {
				map[n1] = i;
			}
		}
		return ret;
	}
};

int main() {

	Solution s;
	vector<int> numbers = { 2, 7, 11, 15 };
	int target = 9;
	vector<int> result = s.twoSum(numbers, target);
	cout << result[0] << ", "<< result[1] << endl;
	system("pause");
}