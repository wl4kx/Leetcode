/**
 * 
 */
package wenxin.leetcode.java;

import java.util.LinkedList;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
public class NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfIslands instance = new NumberOfIslands();
		char[][] grid = new char[5][5];
		char[] r1 =  {'1','1','0','0','0'};
		char[] r2 =  {'1','1','0','0','0'};
		char[] r3 =  {'1','1','0','0','0'};
		char[] r4 =  {'0','0','1','0','0'};
		char[] r5 =  {'0','0','0','1','1'};
		grid[0] = r1;
		grid[1] = r2;
		grid[2] = r3;
		grid[3] = r4;
		grid[4] = r5;
		System.out.println(instance.numIslands(grid));
	}
	
    public int numIslands(char[][] grid) {
    	
    	int numIslands = 0;
    	
    	int height = grid.length;
    	
    	if(height==0){
    		return numIslands;
    	}
    	
    	int width = grid[0].length;
    	
    	for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				if(grid[i][j]=='1'){
					if(grid[i][j] == '1'){
						numIslands++;
						markAdjacent(grid, i, j);
					}
				}
				
			}
		}
    	
    	return numIslands;
    	
    }
    
    private void markAdjacent(char[][] grid, int i_, int j_){
    	int height = grid.length;
    	int width = grid[0].length;
    	
    	LinkedList<Integer> is = new LinkedList<Integer>();
    	LinkedList<Integer> js = new LinkedList<Integer>();
    	
    	is.add(i_);
    	js.add(j_);
    	
    	while(!is.isEmpty()){
    		int i = is.removeLast();
    		int j = js.removeLast();
        	grid[i][j] = '2';
    		if(i-1>=0 && grid[i-1][j]=='1'){
    			is.add(i-1);
    			js.add(j);
    		}
    		if(i+1<height && grid[i+1][j]=='1'){
    			is.add(i+1);
    			js.add(j);
    		}
    		if(j-1>=0 && grid[i][j-1]=='1'){
    			is.add(i);
    			js.add(j-1);
    		}
    		if(j+1<width && grid[i][j+1]=='1'){
    			is.add(i);
    			js.add(j+1);
    		}
    		
    	}
    }

}
