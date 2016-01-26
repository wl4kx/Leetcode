/**
 * 
 */
package wenxin.leetcode.java;


/**
 * @author liao.wenxin
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * @param args
	 */
	/*
	 * problem 108.
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public static void main(String[] args) {
	}
    public static TreeNode sortedArrayToBST(int[] nums) {
    	return findRoot(nums, 0, nums.length-1);
    }
    public static TreeNode findRoot(int[] nums, int start, int end){
    	if(start>end){
    		return null;
    	}
    	int middleIndex = (start + end)/2;
    	TreeNode root = new TreeNode(nums[middleIndex]);
    	root.left = findRoot(nums, start, middleIndex-1);
    	root.right = findRoot(nums, middleIndex+1, end);
    	return root;
    }
}
