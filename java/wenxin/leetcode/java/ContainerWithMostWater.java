package wenxin.leetcode.java;

/*
 * problem 11.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] ir = { 1, 1 };
		System.out.println(maxArea(ir));

	}

	public static int maxArea(int[] height) {

		if (height.length < 2) {
			return 0;
		}

		int li = 0; // left index;
		int ri = height.length - 1; // right index;

		int maxArea = 0;

		while (li < ri) {
			int shorter = Math.min(height[li], height[ri]);
			maxArea = Math.max(maxArea, shorter * (ri - li));
			if (height[li] < height[ri]) {
				li++;
			} else
				ri--;
		}

		return maxArea;
	}

}
