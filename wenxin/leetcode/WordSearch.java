package wenxin.leetcode;


import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {
	public static void main(String[] args){
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "ABCCFSADEESE";
		
		char[][] board2 ={
				{'a','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','a'}
		};
		String word2 = "aaaaaaaaaaab";
		
		char[][] board3 ={
				{'a','a'}
		};
		String word3 = "aaa";
		
		char[][] board4 ={
				{'a','b'},
				{'c','d'}
		};
		String word4 = "cdba";
		
		char[][] board5 ={
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};
		String word5 = "ABCESEEEFS";
		
		WordSearch ws = new WordSearch();
		//WordSearch_OVERTIME ws = new WordSearch_OVERTIME();
		boolean exist = ws.exist(board2, word2);
		System.out.println(exist);
	}
	
	public boolean exist(char[][] board, String word) {
		char firstChar = word.charAt(0);
    	for(int i=0; i<board.length;i++){
    		for(int j = 0; j<board[i].length;j++){
    			if(board[i][j]==firstChar){
    				if(word.length()==1)
    					return true;
    				if(findWord(new Letter(i, j), board, word))
    					return true;
    			}
    		}
    	}
    	return false;
	}
	
	public boolean findWord(Letter letter, char[][] board, String target){
		ArrayList<Letter> arr = new ArrayList<Letter>();
		ArrayList<Boolean[]> previousLettersList = new ArrayList<Boolean[]>();
		ArrayList<String> currentWordList = new ArrayList<String>();
		arr.add(letter);
		currentWordList.add(""+board[letter.r][letter.c]);
		Boolean[] visitedList = new Boolean[board.length*board[0].length];
		Arrays.fill(visitedList, false);
		visitedList[letter.c+letter.r*board[0].length] = true;
		previousLettersList.add(visitedList);
		
		while(!arr.isEmpty()){
			int index = arr.size()-1;
			Letter l = arr.remove(index);
			String currentWord = currentWordList.remove(index);
			Boolean[] visitedArr = previousLettersList.remove(index);
			
			if(currentWord.equals(target))
				return true;
			//System.out.println(currentWord);
			ArrayList<Letter> neighborLetters = new ArrayList<Letter>();
        	if(l.r-1>=0 && board[l.r-1].length>l.c){
        		neighborLetters.add(new Letter(l.r-1,l.c));
        	}
        	if(l.c-1>=0){
        		neighborLetters.add(new Letter(l.r,l.c-1));
        	}
        	if(l.c+1<board[l.r].length){
        		neighborLetters.add(new Letter(l.r,l.c+1));
        	}
        	if(l.r+1<board.length && board[l.r+1].length>l.c){
        		neighborLetters.add(new Letter(l.r+1,l.c));
        	}
        	
        	for(Letter nl : neighborLetters){
        		String newWord = currentWord+board[nl.r][nl.c];
        		if(target.startsWith(newWord)&&(!visitedArr[nl.c+nl.r*board[0].length])){
            		
        
        				//add this new letter to array
        				arr.add(nl);
        				currentWordList.add(newWord);
        				//visitedArr[nl.c+nl.r*board[0].length]=true;
        				
        				Boolean[] tempArr = visitedArr.clone();
        				tempArr[nl.c+nl.r*board[0].length]=true;
        				previousLettersList.add(tempArr);
        			}
        	}        	
		}
		
		
		
		return false;
	}	
	

	
	public class Letter{
		int r;
		int c;
		public Letter(int r, int c){
			this.r=r;
			this.c=c;
		}
		public boolean equals(Letter l){
			return this.r==l.r && this.c==l.c;
		}
		public String toString(){
			return "r:"+r+", c:"+c;
		}
	}
}
