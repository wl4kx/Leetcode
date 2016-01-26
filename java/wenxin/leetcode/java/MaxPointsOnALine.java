package wenxin.leetcode.java;

import java.awt.Point;
import java.util.HashMap;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
	//key is using slope to determine if two points are on the same line. Be careful about duplicate points and points with same x value.
	// because slope = (y2-y1)/(x2-x1) here if x2=x1, will throw exception.
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				// handle duplicates and vertical
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
		}

		return max;
	}
    
}
