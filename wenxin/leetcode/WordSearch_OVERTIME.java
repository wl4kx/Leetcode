package wenxin.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;

public class WordSearch_OVERTIME {
	
	public static void main(String[] args){
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "A";
		WordSearch_OVERTIME ws = new WordSearch_OVERTIME();
		boolean exist = ws.exist(board, word);
		System.out.println(exist);
	}
	
    public boolean exist(char[][] board, String word) {

    	char[] wa = word.toCharArray();
    	char firstChar = wa[0];
    	LinkedList<Letter> startingLetters = new LinkedList<Letter>();
    	//read char board into Letter board
    	Letter[][] letterBoard = new Letter[board.length][];
    	for(int i=0; i<board.length;i++){
    		Letter[] aRow = new Letter[board[i].length];
    		for(int j = 0; j<board[i].length;j++){
    			Letter l = new Letter(i, j, board[i][j]);
    			if(board[i][j]==firstChar){
    				if(word.length()==1)
    					return true;
    				startingLetters.addFirst(l);
    			}
    			aRow[j] = l;
    		}
    		letterBoard[i]=aRow;
    	}

    	while(!startingLetters.isEmpty()){
        	Letter currentLetter = startingLetters.removeLast();
        	LinkedList<Letter> letterList = new LinkedList<Letter>();
        	letterList.add(currentLetter);
        	Word aWord = new Word(letterList);
        	Letter[][] newLetterBoard = letterBoard.clone();
        	newLetterBoard[currentLetter.r][currentLetter.c].setVisited(true);
        	boolean foundTarget = findTargetString(aWord, newLetterBoard, word);
        	if(foundTarget)
        		return true;
    		
    	}
    	
    	
		return false;
        
    }
    
    private boolean findTargetString(Word w, Letter[][] board, String targetStr){
    		Letter l = w.getLastLetter();
    		l.setVisited(true);
        	//int totalRows = board.length;
        	
        	//four neighbor letters.
        	ArrayList<Letter> neighborLetters = new ArrayList<Letter>();
        	if(l.r-1>=0 && board[l.r-1].length>l.c){
        		neighborLetters.add(board[l.r-1][l.c]);
        	}
        	if(l.c-1>=0){
        		neighborLetters.add(board[l.r][l.c-1]);
        	}
        	if(l.c+1<board[l.r].length){
        		neighborLetters.add(board[l.r][l.c+1]);
        	}
        	if(l.r+1<board.length && board[l.r+1].length>l.c){
        		neighborLetters.add(board[l.r+1][l.c]);
        	}

        	for(Letter nl : neighborLetters){
        		if(!nl.isVisited()){
        			String newStr = w.print()+nl.value;
        			if(targetStr.startsWith(newStr)){
        				if(newStr.length()==targetStr.length()){
            				if(newStr.equals(targetStr)){
            					return true;
            				}
            				System.out.println(newStr);
        				}else{
        					//add this new word to list.
        					//LinkedList<Letter> temp = new LinkedList<Letter>();
        					//temp.addAll(w.letters);
        					//Word nw =new Word(temp);
        					//nw.letters.add(nl);
        					//Letter nnl = new Letter(nl);
        					//nl.visited = true;
        					w.letters.add(nl);
        					if(findTargetString(w, board.clone(), targetStr)){
        						return true;
        					}
        					w.letters.removeLast().visited=false;
        				}
        			}

        		}
        	}
			/*
["ABCE"],
["SFCS"],
["ADEE"]
			 */	
    		
		return false;
    	
    }
    
    private class Letter{
    	private int c;
    	private int r;
    	private char value;
    	private boolean visited = false;
    	private Letter(int r, int c, char value){
    		this.c=c;
    		this.r=r;
    		this.value=value;
    	}
    	private boolean isVisited(){
    		return visited;
    	}
    	private void setVisited(boolean visited){
    		this.visited=visited;
    	}
    	public String toString(){
    		return ""+value;
    	}
    }
    private class Word{
    	private LinkedList<Letter> letters;
    	private Word(LinkedList<Letter> letters){
    		this.letters=letters;
    	}
    	private String print(){
    		String str = "";
    		for(Letter l: letters){
    			str += l.value;
    		}
    		return str;
    	}
    	private Letter getLastLetter(){
    		return letters.getLast();
    	}
    	public String toString(){
    		String str = "";
    		for(Letter l: letters){
    			str += l.value;
    		}
    		return str;
    	}
    }
    
}
