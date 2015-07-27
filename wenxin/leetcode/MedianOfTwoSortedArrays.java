package wenxin.leetcode;

/*
 * problem 4.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays{
	
	public static void main(String[] args){
		
		int[] a = {1,2,3,6,7};
		
		int[] b = {4, 5};
		
		System.out.println(findMedianSortedArrays(a, b));
		
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public static int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
   /* public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int length1 = nums1.length;
    	int length2 = nums2.length;
    	
    	
    	
    	if(nums1[length1/2]==nums2[length2/2]){
    		return nums1[length1/2];
    	}
    	
    	if(nums1[length1/2]-nums2[length2/2]==1){
    		return nums2[length2/2];
    	}
    	
    	if(nums1[length1/2]-nums2[length2/2]==-1){
    		return nums1[length1/2];
    	}
    	
    	if(nums1[length1/2]-nums2[length2/2]>1){
    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, length1/2), Arrays.copyOfRange(nums2, length2/2, length2));
    	}
    	
    	if(nums2[length2/2]-nums1[length1/2]>1){
    		return findMedianSortedArrays(Arrays.copyOfRange(nums2, 0, length1/2), Arrays.copyOfRange(nums1, length1/2, length1));
    	}
    	
    	
		return 0;
        
    }*/
	
}