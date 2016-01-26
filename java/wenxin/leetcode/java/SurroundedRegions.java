/**
 * 
 */
package wenxin.leetcode.java;

import java.util.LinkedList;

/**
 * @author liao.wenxin
 *
 */
public class SurroundedRegions {

	/**
	 * @param args
	 */
	/*
	 * problem 130.
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
	 */
	public static void main(String[] args) {
		char[][] board = new char[4][4];
		char[] r1 = {'X', 'X', 'X', 'X'};
		char[] r2 = {'X', 'O', 'O', 'X'};
		char[] r3 = {'X', 'X', 'O', 'X'};
		char[] r4 = {'X', 'O', 'X', 'X'};
		board[0] = r1;
		board[1] = r2;
		board[2] = r3;
		board[3] = r4;
		solve(board);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void solve(char[][] board) {
		/*
		 * search 4 edges first, mark all "O" and their adjacent "O" as "."
		 */
		
		int height = board.length;
		if(height==0){
			return;
		}
		int width = board[0].length;
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		//top edge & bottom edge
		for (int i = 0; i < width; i++) {
			if(board[0][i]=='O'){
				int[] coord = {0, i};
				queue.add(coord);
			}
			
			if(board[height-1][i]=='O'){
				int[] coord = {height-1, i};
				queue.add(coord);
			}
		}
		
		//left edge & right edge
		for (int i = 0; i < height; i++) {
			if(board[i][0]=='O'){
				int[] coord = {i, 0};
				queue.add(coord);
			}
			
			if(board[i][width-1]=='O'){
				int[] coord = {i, width-1};
				queue.add(coord);
			}
		}
		
		while(queue.size()>0){
			int[] coord = queue.removeLast();
			int row = coord[0];
			int column = coord[1];
			if(board[row][column]=='O'){
				board[row][column]='.';
			}
			//check left cell.
			if(column-1>0 && board[row][column-1]=='O'){
				int[] newCoord = {row, column-1};
				queue.add(newCoord);
			}
			
			//check right cell.
			if(column+1 < width-1&& board[row][column+1]=='O'){
				int[] newCoord = {row, column+1};
				queue.add(newCoord);
			}
			
			//check upper cell.
			if(row-1>0 && board[row-1][column]=='O'){
				int[] newCoord = {row-1, column};
				queue.add(newCoord);
			}
			
			//check lower cell.
			if(row+1<height-1 && board[row+1][column]=='O'){
				int[] newCoord = {row+1, column};
				queue.add(newCoord);
			}
		}
		
		//convert "." to "O" and "O" to "X".
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(board[i][j]=='.'){
					board[i][j] = 'O';
				}else if(board[i][j]=='O'){
					board[i][j] = 'X';
				}
			}
		}
	}
}
