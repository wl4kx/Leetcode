/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Analysis http://www.programcreek.com/2014/03/leetcode-maximum-gap-java/

We can use a bucket-sort like algorithm to solve this problem in time of O(n) and space O(n). The basic idea is to project each element of the array to an array of buckets. Each bucket tracks the maximum and minimum elements. Finally, scanning the bucket list, we can get the maximum gap.

The key part is to get the interval:

From: interval * (num[i] - min) = 0 and interval * (max -num[i]) = n
interval = num.length / (max - min)
	 */
	
	class Bucket{
	    int low;
	    int high;
	    public Bucket(){
	        low = -1;
	        high = -1; 
	    }
	}
	 
	public int maximumGap(int[] num) {
	    if(num == null || num.length < 2){
	        return 0;
	    }
	 
	    int max = num[0];
	    int min = num[0];
	    for(int i=1; i<num.length; i++){
	        max = Math.max(max, num[i]);
	        min = Math.min(min, num[i]);
	    }
	 
	    // initialize an array of buckets
	    Bucket[] buckets = new Bucket[num.length+1]; //project to (0 - n)
	    for(int i=0; i<buckets.length; i++){
	        buckets[i] = new Bucket();
	    }
	 
	    double interval = (double) num.length / (max - min);
	    //distribute every number to a bucket array
	    for(int i=0; i<num.length; i++){
	        int index = (int) ((num[i] - min) * interval);
	 
	        if(buckets[index].low == -1){
	            buckets[index].low = num[i];
	            buckets[index].high = num[i];
	        }else{
	            buckets[index].low = Math.min(buckets[index].low, num[i]);
	            buckets[index].high = Math.max(buckets[index].high, num[i]);
	        }
	    }
	 
	    //scan buckets to find maximum gap
	    int result = 0;
	    int prev = buckets[0].high;
	    for(int i=1; i<buckets.length; i++){
	        if(buckets[i].low != -1){
	            result = Math.max(result, buckets[i].low-prev);
	            prev = buckets[i].high;
	        }
	 
	    }
	 
	    return result;
	}
}
