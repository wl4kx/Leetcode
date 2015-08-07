/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 48.
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * For no in-place solution. Check here http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
	 * For in-place solution, very good analysis from http://www.lifeincode.net/programming/leetcode-rotate-image-java/
	 */
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
        int halfN;
        if (n % 2 == 0)
            halfN = n / 2;
        else
            halfN = n / 2 + 1;
        for (int i = 0; i < halfN; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
    
    /*
     * analysis copied to below
     * Analysis

If we want to do this in-place, we need to find the regular pattern of rotating a point. We need to modify four points. For example, we have the matrix like the following.

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25
Now we want to rotate “2”, the element we need to move is “2”, “10”, “24”, “16”. Like the following.

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25
The position of them is (0, 1), (1, 4), (4, 3), (3, 0).

In fact, for any point (x, y), the affected point is (y, n – x – 1), (n – x – 1, n – y – 1), (n – y – 1, x), in which “n” is the size of the matrix. In other words, we need to move point like (x, y) -> (y, n – x – 1) -> (n – x – 1, n – y – 1) -> (n – y – 1, x) -> (x, y).

However, every time we visit a point, we move 4 points. So we need to decide which points we need to visit.

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25
When we process (0, 0), the last element in the first line is moved. In fact, for the first line, we only need to process (0, 0) to (0, n – 2). The affected points are like the following.

1	2	3	4	 5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	 25
For the second line, we need to start from the second element. And ends one element earlier comparing to the first line, which is from (1, 1) to (1, n – 3).

In conclusion, for the ith line, we start from (i, i), and ends at (i, n – 2 – i).

We don’t need to process every line. We only need process half of them. Because it will affect the other half. But we need to be careful about the parity of the number of line.
     */
}
