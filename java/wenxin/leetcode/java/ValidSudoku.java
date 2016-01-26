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
 * problem 36.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidSudoku instance = new ValidSudoku();
		String[] strArr = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			char[] ca = strArr[i].toCharArray();
			board[i] = ca;
		}
		System.out.println(instance.isValidSudoku(board));

	}

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
