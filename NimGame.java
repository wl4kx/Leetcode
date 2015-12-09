
/*
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

Hint:

If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 */
public class NimGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NimGame instance = new NimGame();
		System.out.println(instance.canWinNim(1));
	}
	
	public boolean canWinNim(int n) {

		// boolean dp[] = new boolean[3];
/*		if (n <= 3) {
			return true;
		}*/
		
/*		dp[0] = true;
		dp[1] = true;
		dp[2] = true;

		for (int i = 3; i < n; i++) {
			if(dp[0]==false || dp[1]==false || dp[2]==false){
				dp[0] = dp[1];
				dp[1] = dp[2];
				dp[2] = true;
			}else{
				dp[0] = dp[1];
				dp[1] = dp[2];
				dp[2] = false;
			}
		}

		return dp[2];*/
		
		// a pattern is observed.
		if(n%4==0){
			return false;
		}
		return true;
	}

}
