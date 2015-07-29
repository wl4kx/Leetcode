package wenxin.leetcode;

/*
 * problem 31. Algorithm from wikipedia: https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation instance = new NextPermutation();
		int[] num = {1, 2, 5, 3, 4};
		instance.nextPermutation(num);
		for(int i =0;i<num.length;i++){
			System.out.print(num[i]+", ");
		}
		System.out.println();
		/*
		 * 1, 2 ,3, 4, 5
		 * 1, 2, 3, 5, 4
		 * 1, 2, 4, 3, 5
		 * 1, 2, 4, 5, 3
		 * 1, 2, 5, 3, 4
		 * 1, 2, 5, 4, 3
		 * ...
		 * ...
		 */
	}

    public void nextPermutation(int[] nums) {
        int i = 0;
        int j = 0;
        //From right to left, find the first one that is not in ascending order.
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1])
                continue;
            //From right to left, find the first one that is larger than num[i]
            for (j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i])
                    break;
            }
            break;
        }
        //If we find i, swap the number on position i and j
        if (i >= 0) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        //Reverse the numbers which are on the right of i
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
