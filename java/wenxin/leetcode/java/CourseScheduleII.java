package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {

	public static void main(String[] args) {
		CourseScheduleII instance = new CourseScheduleII();
/*		
		int[][] prerequisites = new int[4][2];
		int[] p1 = {1, 0};
		int[] p2 = {2, 0};
		int[] p3 = {3, 1};
		int[] p4 = {3, 2};
		prerequisites[0] = p1;
		prerequisites[1] = p2;
		prerequisites[2] = p3;
		prerequisites[3] = p4;
		*/
		int[][] prerequisites = new int[2][2];
		int[] p1 = {1, 0};
		int[] p2 = {0, 1};
		prerequisites[0] = p1;
		prerequisites[1] = p2;
		int[] result = instance.findOrder(2, prerequisites);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}

	}

	// key: topological sort, use dfs, see https://en.wikipedia.org/wiki/Topological_sorting
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	
	    //track visited courses, 0: unvisited, 1: permanent mark, -1: temporary mark.
	    int[] visit = new int[numCourses];
    	
	    // use the map to store what courses depend on a course 
	    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	    for(int[] a: prerequisites){
	        if(map.containsKey(a[1])){
	            map.get(a[1]).add(a[0]);
	        }else{
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(a[0]);
	            map.put(a[1], l);
	        }
	    }
	    
	    LinkedList<Integer> result = new LinkedList<Integer>();
	    
	    for (int i = 0; i < numCourses; i++) {
			if(visit[i]==0){
				if(!dfs(i, map, visit, result)){
					return new int[0];
				}
			}
		}
	    
	    int[] ret = new int[result.size()];
	    for(int i=0;i<ret.length;i++){
	    	ret[i] = result.get(i);
	    }
	    return ret;
	    
    }
    
    private boolean dfs(int node, HashMap<Integer,ArrayList<Integer>> map, int[] visit, LinkedList<Integer> result){
    	
		//not a DAG.
    	if(visit[node]==-1){
    		return false;
    	}
		//not visited.
    	if(visit[node]==0){
    		// mark temporarily.
    		visit[node] = -1;
    		ArrayList<Integer> nodes = map.get(node);
    		if(nodes!=null){
    			for(Integer i:nodes){
        			boolean success = dfs(i, map, visit, result);
        			if(!success){
        				return false;
        			}
        		}	
    		}
    		//mark permanently,
    		visit[node] = 1;
    		result.addFirst(node);
    	}
    	return true;
    }
    
}
