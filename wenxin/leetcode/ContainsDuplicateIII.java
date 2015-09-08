/**
 * 
 */
package wenxin.leetcode;

import java.util.TreeSet;

/**
 * @author liao.wenxin
 *
 */
public class ContainsDuplicateIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
	 
		TreeSet<Integer> set = new TreeSet<Integer>();
	 
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			if ((set.floor(c) != null && c <= set.floor(c) + t)
			|| (set.ceiling(c) != null && c >= set.ceiling(c) -t))
				return true;
	 
			set.add(c);
	 
			if (i >= k)
				set.remove(nums[i - k]);
		}
	 
		return false;}
	
}
