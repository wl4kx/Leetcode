package wenxin.leetcode.java;

public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * similar to FindMinimumInRoatedSortedArray. Add one more condition, if left and right are equal, drop left.
	 * http://www.programcreek.com/2014/03/leetcode-find-minimum-in-rotated-sorted-array-ii-java/
	 */
	public int findMin(int[] num) {
	    return findMin(num, 0, num.length-1);
	}
	 
	public int findMin(int[] num, int left, int right){
	    if(right==left){
	        return num[left];
	    }
	    if(right == left +1){
	        return Math.min(num[left], num[right]);
	    }
	    
	    // 3 3 1 3 3 3
	    int middle = (right-left)/2 + left;
	    // already sorted
	    if(num[right] > num[left]){
	        return num[left];
	    //right shift one
	    }else if(num[right] == num[left]){
	        return findMin(num, left+1, right);
	    //go right    
	    }else if(num[middle] >= num[left]){
	        return findMin(num, middle, right);
	    //go left    
	    }else{
	        return findMin(num, left, middle);
	    }
	}
}
