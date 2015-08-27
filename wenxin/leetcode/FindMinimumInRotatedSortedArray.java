package wenxin.leetcode;


/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// key: binary search.
	public int findMin(int[] num) {
		return findMin(num, 0, num.length - 1);
	}
	 
	public int findMin(int[] num, int left, int right) {
		if (left == right)
			return num[left];
		if ((right - left) == 1)
			return Math.min(num[left], num[right]);
	 
		int middle = left + (right - left) / 2;
	 
		// not rotated
		if (num[left] < num[right]) {
			return num[left];
	 
		// go right side
		} else if (num[middle] > num[left]) {
			return findMin(num, middle, right);
	 
		// go left side
		} else {
			return findMin(num, left, middle);
		}
	}
	
}
