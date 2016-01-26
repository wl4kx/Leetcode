package wenxin.leetcode.java;

/*
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameOfLife instance = new GameOfLife();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};

		instance.gameOfLife(board);
		
	}

	/*
	 * A faster solution is to use 2 bits instead of 2 int to store next state.
	 * https://leetcode.com/discuss/68352/easiest-java-solution-with-explanation
	 * To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00 dead (current) -> dead (next)
- 01 live (current) -> dead (next)
- 10 dead (current) -> live (next)
- 11 live (current) -> live (next)
In the beginning, every 2nd state is 0; when next becomes alive change 2nd bit to 1:

live -> die: nbs < 2 || nbs > 3 (we don't need to care!)
live -> live: nbs >= 2 && nbs <= 3
dead -> live: nbs == 3
To get this state, we simple do:

board[i][j] & 1
To get next state, we simple do:

board[i][j] >> 1
	 * 
	 * 
	 * 
	 * public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when 2nd bit will become 1.
            if((board[i][j] & 1) == 1 && (lives >= 2 && lives <= 3)) {
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if((board[i][j] & 1) == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for(int p = Math.max(i - 1, 0); p <= Math.min(i + 1, m - 1); p++) {
        for(int q = Math.max(j - 1, 0); q <= Math.min(j + 1, n - 1); q++) {
            lives += board[p][q] & 1;
        }
    }
    lives -= board[i][j] & 1;
    return lives;
}
	 */
	public void gameOfLife(int[][] board) {

		/*
		 * 0: dead now 
		 * 1: live now 
		 * 2: live now but dead later 
		 * 3: dead now but live later
		 */

		int height = board.length;
		int length = board[0].length;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {

				int nc = 0;

				// top row
				if (i > 0) {

					if (j > 0) {

						if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) {
							nc++;
						}

					}

					if (board[i - 1][j] == 1 ||board[i - 1][j] == 2) {
						nc++;
					}

					if (j + 1 < length) {

						if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) {
							nc++;
						}

					}

				}

				// bottom row
				if (i + 1 < height) {

					if (j > 0) {

						if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) {
							nc++;
						}

					}

					if (board[i + 1][j] == 1 || board[i + 1][j] == 2) {
						nc++;
					}

					if (j + 1 < length) {

						if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) {
							nc++;
						}

					}

				}

				// other two
				if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 2)) {
					nc++;
				}
				if (j + 1 < length && (board[i][j + 1] == 1 || board[i][j + 1] == 2)) {
					nc++;
				}

				System.out.print(nc+", ");

				
				if (board[i][j] == 1) {
					//Any live cell with fewer than two live neighbors dies, as if caused by under-population.
					if (nc < 2) {
						board[i][j] = 2;
					}
					//Any live cell with two or three live neighbors lives on to the next generation.
					else if (nc == 2 || nc == 3) {
						
					}
					//Any live cell with more than three live neighbors dies, as if by over-population.
					else if (nc > 3) {
						board[i][j] = 2;
					}
				}else{
					// board[i][j] == 0
					if(nc==3){
						board[i][j] = 3;
					}
					
				}
	
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				if(board[i][j]==2){
					board[i][j] = 0;
				}else if(board[i][j]==3){
					board[i][j] = 1;
				}
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}
    
}
