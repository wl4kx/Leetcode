/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashSet;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 37. https://leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
 */
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuSolver instance = new SudokuSolver();
		String[] strArr = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			char[] ca = strArr[i].toCharArray();
			board[i] = ca;
		}
		instance.solveSudoku(board);

	}

	public void solveSudoku(char[][] board) {		
		search(board, 0, 0);	
		System.out.println("");
	}
	public boolean found = false;

	public void search(char[][] board, int i, int j) {

		if (board[i][j] == '.') {
			for (int n = 1; n <= 9; n++) {
				if(found)
					return;
				board[i][j] = (char) (n + '0');
				if (isValidSudoku(board)) {
					if (i == 8 && j == 8) {
						found = true;
						return;
					} else if (j < 8) {
						search(board, i, j + 1);
					} else {
						search(board, i + 1, 0);
					}
				}
			}
			// if result not found, return to original value for other searches.
			if (!found)
				board[i][j] = '.';
		} else {
			if (i == 8 && j == 8) {
				found = true;
				return;
			} else if (j < 8) {
				search(board, i, j + 1);
			} else {
				search(board, i + 1, 0);
			}
		}
	}
	
	//below code from problem 36 ValidSudoku.
	public boolean isValidSudoku(char[][] board) {

		// check each 9 cells of small square.
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				HashSet<Integer> set = new HashSet<Integer>();
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if(board[m][n]!='.'){
							if(set.contains(board[m][n]-'0')){
								return false;
							}
							set.add(board[m][n]-'0');	
						}						
					}
				}

			}
		}
		
		//check each row.
		for (int i = 0; i < 9; i ++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < 9; j ++) {
				if(board[i][j]!='.'){
					if(set.contains(board[i][j]-'0')){
						return false;
					}
					set.add(board[i][j]-'0');	
				}		

			}
		}
		
		//check each column.
		for (int i = 0; i < 9; i ++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < 9; j ++) {
				if(board[j][i]!='.'){
					if(set.contains(board[j][i]-'0')){
						return false;
					}
					set.add(board[j][i]-'0');	
				}		

			}
		}
		
		return true;
	}
}
