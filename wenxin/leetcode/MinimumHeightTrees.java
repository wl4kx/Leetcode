package wenxin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?
Note:

(1) According to the definition of tree on Wikipedia: ¡°a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.¡±

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees instance = new MinimumHeightTrees();
		int n = 6;
		int[][] edges = 
				{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
/*		int n = 4;
		int[][] edges =
				{{1, 0}, {1, 2}, {1, 3}};*/
		List<Integer> ret = instance.findMinHeightTrees(n, edges);
		for (int i : ret) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		if(edges.length==0){
			return new ArrayList<Integer>();
		}
		HashMap<Integer, Set<Integer>> map = new HashMap<>();

		// add everything to map.
		for (int i = 0; i < edges.length; i++) {
			if (!map.containsKey(edges[i][0])) {
				Set<Integer> set = new HashSet<>();
				set.add(edges[i][1]);
				map.put(edges[i][0], set);
				if (!map.containsKey(edges[i][1])) {
					Set<Integer> set_ = new HashSet<>();
					set_.add(edges[i][0]);
					map.put(edges[i][1], set_);
				} else {
					map.get(edges[i][1]).add(edges[i][0]);
				}
			} else {
				map.get(edges[i][0]).add(edges[i][1]);
				if (!map.containsKey(edges[i][1])) {
					Set<Integer> set_ = new HashSet<>();
					set_.add(edges[i][0]);
					map.put(edges[i][1], set_);
				} else {
					map.get(edges[i][1]).add(edges[i][0]);
				}
			}
		}

		//start finding min hight.
		int minHeight = Integer.MAX_VALUE;
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int height = findHeight(map, i, 1);
			if (height < minHeight) {
				ret.clear();
				ret.add(i);
				minHeight = height;
			} else if (height == minHeight) {
				ret.add(i);
			}
		}
		return ret;
	}

	private int findHeight(HashMap<Integer, Set<Integer>> map, int start, int height) {
		if (map.get(start).size() == 0) {
			return height;
		}
		int curHeight = -1;
		Integer[] copy = map.get(start).toArray(new Integer[map.get(start).size()]);
		for (int i : copy) {
			map.get(start).remove(i);
			map.get(i).remove(start);
			curHeight = Math.max(curHeight, findHeight(map, i, height + 1));
			// add back.
			map.get(start).add(i);
			map.get(i).add(start);
		}
		return curHeight;
	}

}
